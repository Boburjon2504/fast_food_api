package com.example.adminservice.service;

import com.example.adminservice.dto.ApiResponse;
import com.example.adminservice.entity.Category;
import com.example.adminservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
//    @Mock
//    CategoryRepository categoryRepository;
//
//    @InjectMocks
//    CategoryService categoryService;
//
//    private Category category;
//
//    @BeforeEach
//    public void setup() {
//        category = Category.builder().id(1L).name("Texnika").active(true).build();
//    }
//
//    @DisplayName("Categoryni qo'shish testi")
//    @Test
//    public void saveCategoryTest() {
//        given(categoryRepository.findByName(category.getName())).willReturn(Optional.empty());
//        given(categoryRepository.save(category)).willReturn(category);
//
//        ApiResponse<Category> response = categoryService.add(category);
//        System.out.println(response);
//
//        //servicega borib qaytgandan keyin responsedagi data null emasmi?
//        assertThat(response.getObj()).isNotNull();
//        assertThat(response.getObj().getName()).isEqualTo("Texnika");
//        assertThat(response.isSuccess()).isTrue();
//        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).isEqualTo("Saqlandi");
//
//    }
//
//    @DisplayName("getAll testi")
//    @Test
//    public void getAllTest() {
//
//        Category category1 = Category.builder().id(2L).name("Telefon").active(true).parent(category).build();
//        Category category2 = Category.builder().id(3L).name("Elektronik").active(true).build();
//
//        given(categoryRepository.findAll()).willReturn(List.of(category, category1, category2));
//
//        ApiResponse<List<Category>> response = categoryService.getAll();
//        System.out.println(response);
//
//        assertThat(response.getData().size()).isEqualTo(3);
//        assertThat(response.isSuccess()).isTrue();
//        assertThat(response.getData().get(0)).isEqualTo(category);
//        assertThat(response.getData().get(1).getName()).isEqualTo("Telefon");
//        assertThat(response.getData().isEmpty()).isTrue();
//    }
//
//    @DisplayName("Delete")
//    @Test
//    public void deleteTest() {
//        willDoNothing().given(categoryRepository).deleteById(1L);
//
//        ApiResponse response = categoryService.delete(category.getId());
//        System.out.println(response);
//        verify(categoryRepository,times(1)).deleteById(1L);
//    }

}
