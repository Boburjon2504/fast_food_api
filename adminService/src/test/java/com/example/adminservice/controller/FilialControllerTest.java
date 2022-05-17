package com.example.adminservice.controller;

import com.example.adminservice.Controller.FilialController;
import com.example.adminservice.entity.Filial;
import com.example.adminservice.repository.FilialRepository;
import com.example.adminservice.service.FillialService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilialController.class)
public class FilialControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper objectMapper;
//    @MockBean
//    FilialRepository filialRepository;
//    @MockBean
//    FilialService filialService;
//
//    Filial RECORD_1 = new Filial(1L, "Chorsu", "Chorsu", true);
//    Filial RECORD_2 = new Filial(2L, "Oqtepa", "Oqtepa", true);
//    Filial RECORD_3 = new Filial(3L, "Broadway", "Broadway", true);
//
//    @SneakyThrows
//    @Test
//    public void getAllRecords() {
//        List<Filial> list = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
//
//        //when
//        Mockito.when(filialRepository.findAll()).thenReturn(list);
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/filial").contentType(MediaType.APPLICATION_JSON));
//
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//                .andExpect(jsonPath("$[0].nameUz", is("Chorsu")));
//    }
//
//
//    @Test
//    public void getFilialId_success() throws Exception {
//        Mockito.when(filialRepository.findByIdAndActiveTrue(RECORD_2.getId())).thenReturn(java.util.Optional.of(RECORD_2));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/filial/2")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.nameUz", is("Oqtepa")));
//    }
//
//
//    @Test
//    public void createFilialSuccess() throws Exception {
//        Mockito.when(filialRepository.save(RECORD_1)).thenReturn(RECORD_1);
//
//        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/filial")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.objectMapper.writeValueAsString(RECORD_1));
//
//
//        //        return ResponseEntity.ok("Chotki");
//        mockMvc.perform(requestBuilder)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nameUz", is("Chorsu")))
//                .andExpect(jsonPath("$.active", is(true)));
//
//        //        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
////        mockMvc.perform(requestBuilder)
////                .andExpect(jsonPath("$.success", is(true)));
//
//    }
//
//
//    @Test
//    public void deleteFilialTest() throws Exception {
//
//        Mockito.when(filialRepository.findById(1L)).thenReturn(null);
//
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/filial/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(result ->  assertFalse(result.getResolvedException() instanceof ChangeSetPersister.NotFoundException));
////                .andExpect(result -> assertEquals("Bunaqasi yoq", Objects.requireNonNull(result.getResolvedException()).getMessage()));
//    }
}
