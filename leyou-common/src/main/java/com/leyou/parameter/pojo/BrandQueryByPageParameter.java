package com.leyou.parameter.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/27 10:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandQueryByPageParameter {
    /*
    *   - page：当前页，int
        - rows：每页大小，int
        - sortBy：排序字段，String
        - desc：是否为降序，boolean
        - key：搜索关键词，String
    * */

    private Integer page;
    private Integer rows;
    private String sortBy;
    private Boolean desc;
    private String key;
}
