package com.leyou.service;

import org.springframework.stereotype.Service;
import com.leyou.item.pojo.Category;

import java.util.List;

/**
 * @author DillonXie
 * @version 1.0
 * @date 2019/10/19 18:26
 */
@Service
public interface CategoryService {
    List<Category> queryCategoryByPid(Long pid);
}
