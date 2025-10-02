package com.sujit.blog.controllers;

import com.sujit.blog.payloads.ApiResponse;
import com.sujit.blog.payloads.CategoryDto;
import com.sujit.blog.repositories.CategoryRepo;
import com.sujit.blog.service.impl.CategoryServiceImpl;
import jakarta.validation.Valid;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl service;

    // create Category
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){

        CategoryDto createdCategory = service.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    // update Category
    @PutMapping("/update/{catId}")
    public ResponseEntity<CategoryDto> updatedCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedCategory = service.updateCategory(categoryDto, catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    // delete Category
    @DeleteMapping("/delete/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        service.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category has been deleted successfully", true), HttpStatus.OK);
    }

    // get Category
    @GetMapping("/get/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = service.getCategory(catId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    // getAll Category
    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getALlCategories(){
        List<CategoryDto> categoryDtoList = service.getAllCategory();
        return  new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

}
