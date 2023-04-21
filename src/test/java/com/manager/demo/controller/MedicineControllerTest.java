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

/**
 * This is a JUnit test class for testing the MedicineController class, which is a Spring MVC controller
 * responsible for handling HTTP requests related to medicines.
 */
@RunWith(MockitoJUnitRunner.class)
public class MedicineControllerTest {

    // MockMvc instance for performing HTTP requests and receiving responses
    MockMvc mockMvc;

    // ObjectMapper and ObjectWriter instances for converting Java objects to JSON and vice versa
    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    // Mock instance of MedicineRepository for mocking database interactions
    @Mock
    MedicineRepository medicineRepository;

    // InjectMocks instance of MedicineController for injecting mocked dependencies
    @InjectMocks
    MedicineController medicineController;

    // Sample Medicine instances for testing
    Medicine medicine_1 = new Medicine(23, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45),
            new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));
    Medicine medicine_2 = new Medicine(24, "Paracetomol", "Painkiller", "2 times a day", BigDecimal.valueOf(45.37),
            new Date(2000-01-01), new Date(2001-03-10), 40, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    /**
     * Set up method to initialize the mocks and MockMvc instance before each test.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(medicineController).build();
    }

    /**
     * Test case for testing the getAllMedicines() method of MedicineController, which fetches all medicines
     * from the database and returns them as JSON response.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void getAllMedicines() throws Exception{
        // Mocking the behavior of MedicineRepository.findAll() method to return a list of medicines
        List<Medicine> medicines = new ArrayList<>(Arrays.asList(medicine_1, medicine_2));
        Mockito.when(medicineRepository.findAll()).thenReturn(medicines);

        // Performing a GET request to /getAllMedicine and expecting HTTP status 200 (OK) with a JSON response
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getAllMedicine")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))); // Expecting 2 medicines in the response
    }

    /**
     * Test method for adding a new medicine using the API endpoint /insertMedicine.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void addMedicine() throws Exception {
        // Create a Medicine object to be added
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

        // Convert Medicine object to JSON content
        String content = objectWriter.writeValueAsString(medicine);

        // Prepare the mock request to add the medicine
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertMedicine")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        // Perform the mock request and assert the response status is OK
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * Test method for updating an existing medicine using the API endpoint /updateMedicine.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void updateMedicine() throws Exception {
        // Create a Medicine object to be updated
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

        // Mock the findById() method of medicineRepository to return the existing medicine
        Mockito.when(medicineRepository.findById(medicine_2.getId())).thenReturn(java.util.Optional.ofNullable(medicine_2));

        // Convert Medicine object to JSON content
        String upContent = objectWriter.writeValueAsString(medicineUpdate);

        // Prepare the mock request to update the medicine
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateMedicine")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        // Perform the mock request and assert the response status is OK
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * Test method for deleting a medicine using the API endpoint /deleteMedicine/{id}.
     *
     * @throws Exception if an error occurs during the test
     */
    @Test
    public void deleteMedicine() throws Exception {
        // Prepare the mock request to delete the medicine
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/deleteMedicine/24")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}