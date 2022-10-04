package com.ecommerce.ecommerce.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.DBModel.CategoryJPA;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.repositories.ICategoryRepository;
@Service
public class CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private ICategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        List<Category> allCategories = new LinkedList<Category>();
        for (CategoryJPA categoryJPA : categoryRepository.findAll()) {
            allCategories.add(mapEntityToCategory(categoryJPA));
        }
        return allCategories;
    }

    public Category getOneCategory(String name) {
        Optional<CategoryJPA> category = categoryRepository.findById(name);
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
        if(categoryRepository.existsById(name)){
            CategoryJPA categoryToUpdate = categoryRepository.findById(name).get();

            Category categoryModel = mapEntityToCategory(categoryToUpdate);

            categoryModel.setName(category.getName());
            categoryModel.setSizes(category.getSizes());

            categoryRepository.save(mapCategoryToEntity(categoryModel));

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
        CategoryJPA mapedJPA = new CategoryJPA(category.getName());
        return mapedJPA;
    }


}
