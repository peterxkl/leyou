package com.leyou.service;

import com.leyou.enums.ExceptionEnums;
import com.leyou.exception.LyException;
import com.leyou.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pojo.Category;

import java.util.Collections;
import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/20 15:17
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> resultCategory = categoryMapper.select(category);
        if (CollectionUtils.isEmpty(resultCategory)) {
            throw new LyException(ExceptionEnums.CATEGOEY_NOT_FOUND);
        }
        return resultCategory;
    }
}
