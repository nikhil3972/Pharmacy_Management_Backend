package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.DiseaseType;
import com.manager.demo.entity.Manufacturer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.DiseaseTypeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class DiseaseTypeControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    DiseaseTypeRepository diseaseTypeRepository;

    @InjectMocks
    DiseaseTypeController diseaseTypeController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(93, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicines_1 = new ArrayList<>();
    Medicine medicine_1 = new Medicine(94, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    DiseaseType diseaseType_1 = new DiseaseType(17, "Viral", medicines, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    DiseaseType diseaseType_2 = new DiseaseType(18, "Viral", medicines_1, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(diseaseTypeController).build();
    }

    @Test
    public void getAllDiseaseType() throws Exception{
        List<DiseaseType> diseaseType = new ArrayList<>(Arrays.asList(diseaseType_1, diseaseType_2));
        Mockito.when(diseaseTypeRepository.findAll()).thenReturn(diseaseType);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllDiseaseType")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void addDiseaseType() throws Exception{
        DiseaseType diseaseType = DiseaseType.builder()
                .id(19)
                .type("Non Viral")
                .medicine((List<Medicine>) medicines)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

//        Mockito.when(diseaseTypeRepository.save(diseaseType)).thenReturn(diseaseType);
        String content = objectWriter.writeValueAsString(diseaseType);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertDiseaseType")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void updateDiseaseType() throws Exception{
        DiseaseType diseaseTypeUpdate = DiseaseType.builder()
                .id(18)
                .type("Non Viral")
                .medicine((List<Medicine>) medicines_1)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(diseaseTypeRepository.findById(diseaseType_2.getId())).thenReturn(java.util.Optional.ofNullable(diseaseType_2));
//        Mockito.when(diseaseTypeRepository.save(diseaseTypeUpdate)).thenReturn(diseaseTypeUpdate);

        String upContent = objectWriter.writeValueAsString(diseaseTypeUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateDiseaseType")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void deleteDiseaseType() throws Exception{
//        Mockito.when(diseaseTypeRepository.findById(diseaseType_2.getId())).thenReturn(Optional.of(diseaseType_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteDiseaseType/18")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
