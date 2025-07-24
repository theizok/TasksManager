package com.example.tasks.Controller;

import com.example.tasks.Entity.Category;
import com.example.tasks.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("getAll")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @PostMapping("add")
    public Category addCategory(Category category){
        return categoryService.addCategory(category);
    }

    @PatchMapping("update")
    public Category updateCategory(long id, Category newCategory){
        return categoryService.updateCategory(id, newCategory);
    }

    @DeleteMapping("delete")
    public void deleteCategory(long id){
        categoryService.deleteCategory(id);
    }
}
