package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.MedicineRepository;
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
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class MedicineControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    MedicineRepository medicineRepository;

    @InjectMocks
    MedicineController medicineController;

    Medicine medicine_1 = new Medicine(23, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));
    Medicine medicine_2 = new Medicine(24, "Paracetomol", "Painkiller", "2 times a day", BigDecimal.valueOf(45.37), new Date(2000-01-01), new Date(2001-03-10), 40, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(medicineController).build();
    }

    @Test
    public void getAllMedicines() throws Exception{
        List<Medicine> medicines = new ArrayList<>(Arrays.asList(medicine_1, medicine_2));
        Mockito.when(medicineRepository.findAll()).thenReturn(medicines);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getAllMedicine")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void addMedicine() throws Exception{
        Medicine medicine = Medicine.builder()
                .id(25)
                .name("Inhalor")
                .description("For cold")
                .dosage("any time")
                .price(BigDecimal.valueOf(13.45))
                .manufacture_date(new Date(2000-01-01))
                .expiry_date(new Date(2000-01-01))
                .current_stock(60)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

//        Mockito.when(medicineRepository.save(medicine)).thenReturn(medicine);
        String content = objectWriter.writeValueAsString(medicine);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertMedicine")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void updateMedicine() throws Exception{
        Medicine medicineUpdate = Medicine.builder()
                .id(24)
                .name("Dolo-650")
                .description("Dolo-650 instead of paracetomol")
                .dosage("2 times a day")
                .price(BigDecimal.valueOf(29.45))
                .manufacture_date(new Date(2000-01-01))
                .expiry_date(new Date(2000-01-01))
                .current_stock(60)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(medicineRepository.findById(medicine_2.getId())).thenReturn(java.util.Optional.ofNullable(medicine_2));
//        Mockito.when(medicineRepository.save(medicineUpdate)).thenReturn(medicineUpdate);

        String upContent = objectWriter.writeValueAsString(medicineUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateMedicine")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void deleteMedicine() throws Exception{
//        Mockito.when(medicineRepository.findById(medicine_2.getId())).thenReturn(Optional.of(medicine_2));

        mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteMedicine/24")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
