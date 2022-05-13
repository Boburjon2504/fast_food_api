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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FilialController.class)
public class FilialControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    RequestBuilder request;
    @MockBean
    FilialRepository filialRepository;
    @MockBean
    FillialService fillialService;

    Filial RECORD_1 = new Filial(1L, "chorsu", "chorsu");
    Filial RECORD_2 = new Filial(2L, "2222", "2222");
    Filial RECORD_3 = new Filial(3L, "3333", "3333");

    @SneakyThrows
    @Test
    public void getAllRecords() throws Exception {
        List<Filial> filials = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));

        Mockito.when(filialRepository.findAll()).thenReturn(filials);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/filial")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(3)))
                .andExpect(jsonPath("$[0].nameUz",is("chorsu")));
    }

    @SneakyThrows
    @Test
    public void createFilialSucces(){
        Mockito.when(filialRepository.save(RECORD_1)).thenReturn(RECORD_1);

        MockMvcRequestBuilders.post("/filial")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(RECORD_1));

        mockMvc.perform(request).andExpect(status().isOk());
    }
}
