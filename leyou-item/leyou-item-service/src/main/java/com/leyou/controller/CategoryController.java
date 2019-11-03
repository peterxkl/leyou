package com.leyou.controller;

import com.leyou.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/19 18:27
 */
@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    private  CategoryService categoryService;

    /**
     * 1.根据父节点查询商品类目
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Category>> queryCategoryByPid(@RequestParam("Pid") Long pid) {
        return ResponseEntity.ok(categoryService.queryCategoryByPid(pid));
    }


    /**
     * 2.用于修改品牌信息时，商品分类信息的回显
     * @param bid
     * @return
     */


    /**
     * 3.保存
     * @return
     */



    /**
     * 4.更新
     * @return
     */


    /**
     * 5.删除
     * @return
     */


    /**
     * 6.根据分类id集合查询分类名称
     * @param ids
     * @return
     */


    /**
     * 7.根据分类id集合查询分类名称
     * @param ids
     * @return
     */


    /**
     * 8.根据分类id集合查询分类名称
     * @param id
     * @return
     */


}
