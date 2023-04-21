package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Disease;
import com.manager.demo.entity.DiseaseType;
import com.manager.demo.entity.Manufacturer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.DiseaseRepository;
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
public class DiseaseControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    DiseaseRepository diseaseRepository;

    @InjectMocks
    DiseaseController diseaseController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(49, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicines_1 = new ArrayList<>();
    Medicine medicine_1 = new Medicine(50, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<DiseaseType> diseaseTypes = new ArrayList<>();
    DiseaseType diseaseType = new DiseaseType(77, "Viral", medicines, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<DiseaseType> diseaseTypes_1 = new ArrayList<>();
    DiseaseType diseaseType_1 = new DiseaseType(78, "Viral", medicines_1, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Disease disease_1 = new Disease(13, "Fever", "Increased Body Temperature", diseaseTypes, "Nagesh", "Rahul", new Date(2000-01-01), new Date(2000-01-01));

    Disease disease_2 = new Disease(14, "Cold", "Cough", diseaseTypes_1, "Nagesh", "Rahul", new Date(2000-01-01), new Date(2000-01-01));

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(diseaseController).build();
    }

    @Test
    public void getAllDiseases() throws Exception{
        List<Disease> diseases = new ArrayList<>(Arrays.asList(disease_1, disease_2));
        Mockito.when(diseaseRepository.findAll()).thenReturn(diseases);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllDisease")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void addDisease() throws Exception{
        Disease disease = Disease.builder()
                .id(15)
                .name("Cold")
                .info("Sneezing")
                .disease_type((List<DiseaseType>) diseaseTypes_1)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

//        Mockito.when(diseaseRepository.save(disease)).thenReturn(disease);
        String content = objectWriter.writeValueAsString(disease);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertDisease")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void updateDisease() throws Exception{
        Disease diseaseUpdate = Disease.builder()
                .id(14)
                .name("Cold")
                .info("Cough")
                .disease_type((List<DiseaseType>) diseaseTypes)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(diseaseRepository.findById(disease_2.getId())).thenReturn(java.util.Optional.ofNullable(disease_2));
//        Mockito.when(diseaseRepository.save(diseaseUpdate)).thenReturn(diseaseUpdate);

        String upContent = objectWriter.writeValueAsString(diseaseUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateDisease")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void deleteDisease() throws Exception{
//        Mockito.when(diseaseRepository.findById(disease_2.getId())).thenReturn(Optional.of(disease_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteDisease/11")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}