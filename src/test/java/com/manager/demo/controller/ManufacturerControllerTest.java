package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Manufacturer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.ManufacturerRepository;
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
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This is a JUnit test class for the ManufacturerController class.
 * It uses the MockitoJUnitRunner to mock the required dependencies.
 */
@RunWith(MockitoJUnitRunner.class)
public class ManufacturerControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    ManufacturerRepository manufacturerRepository;

    @InjectMocks
    ManufacturerController manufacturerController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(35, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicines_1 = new ArrayList<>();
    Medicine medicine_1 = new Medicine(36, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Manufacturer manufacturer_1 = new Manufacturer(10, "Tesla", "8543643478", medicines, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Manufacturer manufacturer_2 = new Manufacturer(11, "Cisco", "7478287379", medicines_1, "Nagesh", "Rahul", new Date(2000-01-01), new Date(2000-01-01));


    /**
     * Set up the test environment before running the tests.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(manufacturerController).build();
    }


    /**
     * Test method for retrieving all manufacturers from the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void getAllManufacturers() throws Exception{
        List<Manufacturer> manufacturers = new ArrayList<>(Arrays.asList(manufacturer_1, manufacturer_2));
        Mockito.when(manufacturerRepository.findAll()).thenReturn(manufacturers);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllManufacturer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    /**
     * Test method for adding a new manufacturer record to the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void addManufacturer() throws Exception{
        Manufacturer manufacturer = Manufacturer.builder()
                .id(12)
                .name("Cipla")
                .contact("8328528894")
                .medicine((List<Medicine>) medicines)
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

//        Mockito.when(manufacturerRepository.save(manufacturer)).thenReturn(manufacturer);
        String content = objectWriter.writeValueAsString(manufacturer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertManufacturer")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    /**
     * Test method for updating a manufacturer record in the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void updateManufacturer() throws Exception{
        Manufacturer manufacturerUpdate = Manufacturer.builder()
                .id(11)
                .name("CiscoTrack")
                .contact("4328324848")
                .medicine((List<Medicine>) medicines)
                .created_by("Mahesh")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(manufacturerRepository.findById(manufacturer_2.getId())).thenReturn(java.util.Optional.ofNullable(manufacturer_2));
//        Mockito.when(manufacturerRepository.save(manufacturerUpdate)).thenReturn(manufacturerUpdate);

        String upContent = objectWriter.writeValueAsString(manufacturerUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateManufacturer")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    /**
     * Test method for deleting a manufacturer record from the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void deleteManufacturer() throws Exception{
//        Mockito.when(manufacturerRepository.findById(manufacturer_2.getId())).thenReturn(Optional.of(manufacturer_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteManufacturer/11")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }
}
