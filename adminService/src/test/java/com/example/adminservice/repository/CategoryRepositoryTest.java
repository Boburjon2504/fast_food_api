package com.example.adminservice.repository;

import com.example.adminservice.entity.Category;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @Order(1)
    public void saveCategoryTest(){
        Category category = Category.builder().id(1L).name("ketmon").build();
        categoryRepository.save(category);

        assertThat(categoryRepository.findAll().size()).isEqualTo(1);
//       assertThat(category.getId()).isGreaterThan(0); true oxawadi
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void  getOneTest(){
        Category byId = categoryRepository.findById(1L).get();

        assertThat(byId.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void updateCategoryTest(){
        Category edit = categoryRepository.findById(1L).get();

        edit.setName("casc");
        categoryRepository.save(edit);

        assertThat(edit.getName()).isEqualTo("casc");

    }



}
