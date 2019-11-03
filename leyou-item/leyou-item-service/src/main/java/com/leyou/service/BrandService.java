package com.leyou.service;

import com.leyou.common.pojo.PageResult;
import com.leyou.parameter.pojo.BrandQueryByPageParameter;
import pojo.Brand;

import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/27 11:00
 */
public interface BrandService {
    /**
     * 分页查询
     * @param brandQueryByPageParameter
     * @return
     */
    PageResult<Brand> queryBrandByPage(BrandQueryByPageParameter brandQueryByPageParameter);

    void saveBrand(Brand brand, List<Long> cids);

    void updateBrand(Brand brand, List<Long> cids);

    void deleteBrand(Long bid);
}
