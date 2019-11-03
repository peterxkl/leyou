package com.leyou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.enums.ExceptionEnums;
import com.leyou.exception.LyException;
import com.leyou.mapper.BrandMapper;
import com.leyou.parameter.pojo.BrandQueryByPageParameter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Brand;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/27 10:59
 */
@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandMapper brandMapper;

    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    @Override
    public PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter) {

        /**
         * 1.分页
         */
        PageHelper.startPage(brandQueryByPageParameter.getPage(),brandQueryByPageParameter.getRows());

        /**
         *  2.排序
         */
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(brandQueryByPageParameter.getSortBy())){
            example.setOrderByClause(brandQueryByPageParameter.getSortBy()+(brandQueryByPageParameter.getDesc()? " DESC":" ASC"));
        }
        /**
         * 3.查询
         */
        if(StringUtils.isNotBlank(brandQueryByPageParameter.getKey())) {
            example.createCriteria().orLike("name", brandQueryByPageParameter.getKey()+"%").orEqualTo("letter", brandQueryByPageParameter.getKey().toUpperCase());
        }
        List<Brand> list=this.brandMapper.selectByExample(example);

        /**
         * 4.创建PageInfo
         */
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        /**
         * 5.返回分页结果
         */
        return new PageResult<>(pageInfo.getTotal(),pageInfo.getList());
    }


    @Override
    @Transactional     //记得加这个注解
    public void saveBrand(Brand brand, List<Long> cids) {
        //新增Brand
        int count = brandMapper.insert(brand);
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
        }
        //保存中间表
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid, brand.getId());//为什么这里能获取到id???新增后的自动回显???
            if (count != 1) {
                throw new LyException(ExceptionEnums.BRAND_SAVE_ERROR);
            }
        }
    }

    @Override
    @Transactional
    public void updateBrand(Brand brand, List<Long> cids) {
        //修改Brand
        int count = brandMapper.updateByPrimaryKey(brand);
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_UPDATE_ERROR);
        }
        //删除原有中间表关系
        brandMapper.deleteByBrandIdInCategoryBrand(brand.getId());
        //保存新的中间表关系
        for (Long cid : cids) {
            count = brandMapper.insertCategoryBrand(cid,brand.getId());
            if (count != 1) {
                throw new LyException(ExceptionEnums.BRAND_UPDATE_ERROR);
            }
        }
    }

    @Override
    public void deleteBrand(Long bid) {
        //删除品牌信息
        int count = brandMapper.deleteByPrimaryKey(bid);
        if (count != 1) {
            throw new LyException(ExceptionEnums.BRAND_DELETE_ERROR);
        }
        //删除关联表信息
        brandMapper.deleteByBrandIdInCategoryBrand(bid);
    }


}
