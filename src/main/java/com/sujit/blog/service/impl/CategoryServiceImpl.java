package com.sujit.blog.service.impl;

import com.sujit.blog.entities.Category;
import com.sujit.blog.exceptions.ResourceNotFoundException;
import com.sujit.blog.payloads.CategoryDto;
import com.sujit.blog.repositories.CategoryRepo;
import com.sujit.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    // create
    @Override
    public CategoryDto  createCategory(CategoryDto categoryDto){
        Category category = dtoToEntity(categoryDto);
        Category savedCategory = categoryRepo.save(category);
        return entityToDto(savedCategory);
    }

    // update
    @Override
    public CategoryDto  updateCategory(CategoryDto categoryDto, Integer categoryId){

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCategory = categoryRepo.save(category);

        return entityToDto(updatedCategory);

    }

    // delete
    @Override
    public void deleteCategory(Integer categoryId){

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
        categoryRepo.deleteById(categoryId);

    }

    // get
    @Override
    public CategoryDto getCategory(Integer categoryId){

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ", "Category Id", categoryId));
        return entityToDto(category);

    }

    // getAll
    @Override
    public List<CategoryDto> getAllCategory(){

        List<Category> categoryList = categoryRepo.findAll();

        return categoryList.stream()
                .map(this::entityToDto).collect(Collectors.toList());

    }

    // entity to dto
    private CategoryDto entityToDto(Category savedCategory) {
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    // dto to entity
    private Category dtoToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
}
