package com.leyou.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.parameter.pojo.BrandQueryByPageParameter;
import com.leyou.service.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pojo.Brand;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/27 10:58
 */
@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandServiceImpl brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param sortBy
     * @param desc
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                                              @RequestParam(value = "sortBy", required = false) String sortBy,
                                                              @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
                                                              @RequestParam(value = "key", required = false) String key){
        BrandQueryByPageParameter brandQueryByPageParameter=new BrandQueryByPageParameter(page,rows,sortBy,desc,key);
        PageResult<Brand> result = this.brandService.queryBrandByPage(brandQueryByPageParameter);
        if(result == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(result);
    }
}
