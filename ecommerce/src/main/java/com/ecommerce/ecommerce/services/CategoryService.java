package com.ecommerce.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.repositories.ICategoryRepository;
import java.util.ArrayList;
@Service
public class CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> allCategories = new ArrayList<>();
        for (CategoryJPA categoryJPA : categoryRepository.findAll()) {
            allCategories.add(mapEntityToCategory(categoryJPA));
        }
        return allCategories;
    }

    public Category getOneCategory(String name) {
        Optional<CategoryJPA> category = categoryRepository.findByName(name);
        if(category.isPresent()){
            return mapEntityToCategory(category.get());
        }
        else {
            return null;
        }
    }

    public Category createNewCategory(Category category) {
        if(category != null){
            CategoryJPA categoryJPA = mapCategoryToEntity(category);

            categoryRepository.save(categoryJPA);

            return category;
        }
        return null;
    }

    public Category updateCategory(String name, Category category) {
        if(categoryRepository.findByName(name) != null){
            Optional<CategoryJPA> categoryToUpdate = categoryRepository.findByName(name);

//            Category categoryModel = mapEntityToCategory(categoryToUpdate.get());
//
//            categoryModel.setName(category.getName());
//            categoryModel.setSizes(category.getSizes());

            

            categoryToUpdate.get().setName(category.getName());
            categoryToUpdate.get().setSizes(category.getSizes());
            categoryToUpdate.get().setProducts(categoryToUpdate.get().getProducts());

            categoryRepository.save(categoryToUpdate.get());

            return category;
        }
        return null;
    }
    /* MAPPERS */

    public Category mapEntityToCategory(CategoryJPA categoryJPA){
        Category mapedCategory = modelMapper.map(categoryJPA, Category.class);
        return mapedCategory;
    }

    public CategoryJPA mapCategoryToEntity(Category category){
        CategoryJPA mapedJPA = new CategoryJPA(category.getName(), category.getSizes());
        return mapedJPA;
    }


}
