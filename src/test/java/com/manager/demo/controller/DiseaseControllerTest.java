//package com.manager.demo.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.manager.demo.entity.Disease;
//import com.manager.demo.entity.DiseaseType;
//import com.manager.demo.entity.Manufacturer;
//import com.manager.demo.entity.Medicine;
//import com.manager.demo.repository.DiseaseRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.math.BigDecimal;
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * JUnit test class for Disease Controller.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class DiseaseControllerTest {
//
//    MockMvc mockMvc;
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectWriter objectWriter = objectMapper.writer();
//
//    @Mock
//    DiseaseRepository diseaseRepository;
//
//    @InjectMocks
//    DiseaseController diseaseController;
//
//    List<Medicine> medicines = new ArrayList<>();
//    Medicine medicine = new Medicine(49, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//    Medicine medicineOne = new Medicine(50, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//
//    List<DiseaseType> diseaseTypes = new ArrayList<>();
//    DiseaseType diseaseType = new DiseaseType(77, "Viral", medicines);
//    DiseaseType diseaseTypeOne = new DiseaseType(78, "Viral", medicines);
//
//    Disease diseaseOne = new Disease(13, "Fever", "Increased Body Temperature", "Paracetamol");
//    Disease diseaseTwo = new Disease(14, "Cold", "Cough", "Paracetamol");
//
//    /**
//     * Sets up the test environment by initializing the Mockito annotations and creating a standalone instance of the
//     * DiseaseController.
//     */
//    @Before
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(diseaseController).build();
//    }
//
//    /**
//     * Tests the getAllDiseases() method of the DiseaseController by mocking the disease repository and using MockMvc to
//     * perform a GET request and validate the response.
//     * @throws Exception if an error occurs during the test
//     */
//    @Test
//    public void getAllDiseases() throws Exception{
//        List<Disease> diseases = new ArrayList<>(Arrays.asList(diseaseOne, diseaseTwo));
//        Mockito.when(diseaseRepository.findAll()).thenReturn(diseases);
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/getAllDisease")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
//    }
//
//    /**
//     * Tests the addDisease() method of the DiseaseController by creating a Disease object, converting it to JSON, and using
//     * MockMvc to perform a POST request and validate the response.
//     * @throws Exception if an error occurs during the test
//     */
//    @Test
//    public void addDisease() throws Exception{
//        List<Medicine> medicines = new ArrayList<>();
//        Medicine medicine = new Medicine(49, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//        Medicine medicineOne = new Medicine(50, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//        medicines.add(medicine);
//        medicines.add(medicineOne);
//
//        List<DiseaseType> diseaseTypes = new ArrayList<>();
//        DiseaseType diseaseType = new DiseaseType(77, "Viral", medicines);
//        DiseaseType diseaseTypeOne = new DiseaseType(78, "Viral", medicines);
//        diseaseTypes.add(diseaseType);
//        diseaseTypes.add(diseaseTypeOne);
//
//        Disease disease = Disease.builder()
//                .id()
//                .diseaseName("Cold")
//                .diseaseInfo("Sneezing")
//                .recMed("Citrazin")
//                .build();
//
//        String content = objectMapper.writeValueAsString(disease);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertDisease")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);
//
//        System.out.println(content);
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * Tests the updateDisease() method of the DiseaseController by creating a Disease object to update, mocking the disease
//     * repository to return a disease, converting the updated Disease object to JSON, and using MockMvc to perform a PUT request
//     * and validate the response.
//     * @throws Exception if an error occurs during the test
//     */
//    @Test
//    public void updateDisease() throws Exception{
//        List<Medicine> medicines = new ArrayList<>();
//        Medicine medicine = new Medicine(49, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//        Medicine medicineOne = new Medicine(50, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35);
//        medicines.add(medicine);
//        medicines.add(medicineOne);
//
//        Disease diseaseUpdate = Disease.builder()
//                .id(14)
//                .diseaseName("Cold")
//                .diseaseInfo("Cough")
//                .recMed("Paracetamol")
//                .build();
//
//        Mockito.when(diseaseRepository.findById(diseaseTwo.getId())).thenReturn(Optional.ofNullable(diseaseTwo));
//
//        String upContent = objectMapper.writeValueAsString(diseaseUpdate);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateDisease")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(upContent);
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk());
//    }
//
//    /**
//     * Sends a HTTP DELETE request to delete a disease with the specified ID.
//     * @throws Exception if there is an error performing the HTTP request.
//     */
//    @Test
//    public void deleteDisease() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders
//                        .delete("/deleteDisease/11")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//}
