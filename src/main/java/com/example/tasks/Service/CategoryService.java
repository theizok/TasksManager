package com.example.tasks.Service;

import com.example.tasks.Entity.Category;
import com.example.tasks.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Obtener todas la categorias
    public List<Category> getCategories(){
      return categoryRepository.findAll();
    }

    // Agregar categoria
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    // Actualizar categoria
    public Category updateCategory(long id, Category newCategory){
        return categoryRepository.findById(id).map(category -> {
            category.setName(newCategory.getName());
            category.setDescription(newCategory.getDescription());
            return categoryRepository.save(category);
        }).orElseThrow(() -> new RuntimeException("No se encontro la categoria a actualizar"));
    }

    // Eliminar categoria
    public void deleteCategory(long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            categoryRepository.deleteById(id);
        }else {
            throw new RuntimeException("No se encontro la categoria a eliminar");
        }
    }
}
