package com.leyou.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空！"),
    CATEGOEY_NOT_FOUND(400,"没找到category！");
    private int code;
    private String msg;
}
