package com.example.adminservice.service;

import com.example.adminservice.entity.Category;
import com.example.adminservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    CategoryRepository categoryRepository;
    @InjectMocks
    CategorySrevice categorySrevice;

    private Category category;

    @BeforeEach
    public void setUp() {
        Category.builder()
                .id(1L)
                .name("texnika")
                .active(true)
                .build();
    }

//    @DisplayName("categoriyani qoshish testi")
//    @Test
//    public void savecategoryTest(){
//        given()
//    }

}
