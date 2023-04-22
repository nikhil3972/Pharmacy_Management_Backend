package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.entity.Sales;
import com.manager.demo.repository.SalesRepository;
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
 * JUnit test class for testing SalesController methods using Mockito framework.
 */
@RunWith(MockitoJUnitRunner.class)
public class SalesControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    SalesRepository salesRepository;

    @InjectMocks
    SalesController salesController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(40, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicinesOne = new ArrayList<>();
    Medicine medicineOne = new Medicine(41, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));


    List<Customer> customers = new ArrayList<>();
    Customer customerOne = new Customer(90, "Nikhil", "Dethe", "8888496629", "dethenikhil7578@gmail.com", medicines, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Customer> customersOne = new ArrayList<>();
    Customer customerTwo = new Customer(91, "Nikhil", "Dethe", "8888496629", "dethenikhil7578@gmail.com", medicines, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Sales salesOne = new Sales(3, new Date(2000-01-01), customers, BigDecimal.valueOf(400.25), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Sales salesTwo = new Sales(4, new Date(2000-01-01), customersOne, BigDecimal.valueOf(300.14), "Harshal", "Ramesh", new Date(2000-01-01), new Date(2000-01-01));

    /**
     * Set up method to initialize mock objects and create the mockMvc instance for testing the salesController.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(salesController).build();
    }

    /**
     * This method tests the getAllSales() method of SalesController by mocking the repository call and verifying the response.
     * @throws Exception if any error occurs during test execution.
     */
    @Test
    public void getAllSales() throws Exception{
        //Arrange
        List<Sales> sales = new ArrayList<>(Arrays.asList(salesOne, salesTwo));
        Mockito.when(salesRepository.findAll()).thenReturn(sales);

        //Act and Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllSales")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    /**
     * This method tests the addSale() method of SalesController by creating a mock Sales object, calling the method and verifying the response.
     * @throws Exception if any error occurs during test execution.
     */
    @Test
    public void addSale() throws Exception{
        //Arrange
        Sales sales = Sales.builder()
                .saleId(5)
                .saleDate(new Date(2000-01-01))
                .customer((List<Customer>) customersOne)
                .totalCost(BigDecimal.valueOf(300.14))
                .createdBy("Harshal")
                .modifiedBy("Amit")
                .createdTimestamp(new Date(2000-01-01))
                .modifiedTimestamp(new Date(2000-01-01))
                .build();

        String content = objectWriter.writeValueAsString(sales);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertSales")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        //Act and Assert
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * This method tests the updateSales() method of SalesController by creating a mock Sales object, mocking the repository call and verifying the response.
     * @throws Exception if any error occurs during test execution.
     */
    @Test
    public void updateSales() throws Exception{
        //Arrange
        Sales salesUpdate = Sales.builder()
                .saleId(4)
                .saleDate(new Date(2000-01-01))
                .customer((List<Customer>) customersOne)
                .totalCost(BigDecimal.valueOf(300.14))
                .createdBy("Harshal")
                .modifiedBy("Amit")
                .createdTimestamp(new Date(2000-01-01))
                .modifiedTimestamp(new Date(2000-01-01))
                .build();

        Mockito.when(salesRepository.findById(salesTwo.getId())).thenReturn(java.util.Optional.ofNullable(salesTwo));

        String upContent = objectWriter.writeValueAsString(salesUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateSales")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        //Act and Assert
        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * This method tests the deleteSales() method of SalesController by mocking the repository call and verifying the response.
     * @throws Exception if any error occurs during test execution.
     */
    @Test
    public void deleteSales() throws Exception{
        //Act and Assert
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteSales/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



}
