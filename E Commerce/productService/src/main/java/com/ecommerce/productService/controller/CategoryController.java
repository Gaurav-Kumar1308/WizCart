package com.ecommerce.productService.controller;

import com.ecommerce.productService.entity.Category;
import com.ecommerce.productService.service.CategoryService;
import com.ecommerce.productService.service.impl.NextSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/db/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NextSequenceService nextSequenceService;



    @GetMapping("/{id}")
    public Category get(@PathVariable(name = "id") Long id){
        return categoryService.get(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category){
        category.setId(nextSequenceService.getNextSequence("customSequenceCategory"));
        return categoryService.save(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category){
        return  categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name="id") Long id){
        categoryService.delete(id);
    }

}
