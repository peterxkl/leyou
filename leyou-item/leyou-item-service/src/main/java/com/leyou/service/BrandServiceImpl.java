package com.leyou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.pojo.PageResult;
import com.leyou.mapper.BrandMapper;
import com.leyou.parameter.pojo.BrandQueryByPageParameter;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
