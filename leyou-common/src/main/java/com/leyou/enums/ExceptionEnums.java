package com.leyou.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGOEY_NOT_FOUND(400,"没找到category！"),
    BRAND_SAVE_ERROR(500,"新增品牌失败！"),
    BRAND_UPDATE_ERROR(500,"修改品牌失败！"),
    BRAND_DELETE_ERROR(500,"删除品牌失败！");
    private int code;
    private String msg;
}
