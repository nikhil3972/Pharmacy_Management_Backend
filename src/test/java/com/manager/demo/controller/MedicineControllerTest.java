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
    Medicine medicineOne = new Medicine(23, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45),
            new Date(2000-01-01), new Date(2025-03-10), 35);
    Medicine medicineTwo = new Medicine(24, "Paracetomol", "Painkiller", "2 times a day", BigDecimal.valueOf(45.37),
            new Date(2000-01-01), new Date(2026-03-10), 40);

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
        List<Medicine> medicines = new ArrayList<>(Arrays.asList(medicineOne, medicineTwo));
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
                .medicineId(25)
                .medicineName("Inhalor")
                .description("For cold")
                .dosage("any time")
                .price(BigDecimal.valueOf(13.45))
                .manufactureDate(Date.valueOf("1990-01-01"))
                .expiryDate(Date.valueOf("2024-01-01"))
                .currentStock(60)
                .build();


        // Convert Medicine object to JSON content
        String content = objectMapper.writeValueAsString(medicine);

        // Prepare the mock request to add the medicine
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertMedicine")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);
//        System.out.println(content);
//         Perform the mock request and assert the response status is OK
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
                .medicineId(24)
                .medicineName("Dolo-650")
                .description("Dolo-650 instead of paracetomol")
                .dosage("2 times a day")
                .price(BigDecimal.valueOf(29.45))
                .manufactureDate(Date.valueOf("2000-01-01"))
                .expiryDate(Date.valueOf("2024-01-01"))
                .currentStock(60)
                .build();

        // Mock the findById() method of medicineRepository to return the existing medicine
        Mockito.when(medicineRepository.findById(medicineTwo.getId())).thenReturn(java.util.Optional.ofNullable(medicineTwo));

        // Convert Medicine object to JSON content
        String upContent = objectMapper.writeValueAsString(medicineUpdate);

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
