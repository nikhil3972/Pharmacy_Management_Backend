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

    List<Medicine> medicines_1 = new ArrayList<>();
    Medicine medicine_1 = new Medicine(41, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));


    List<Customer> customers = new ArrayList<>();
    Customer customer_1 = new Customer(90, "Nikhil", "Dethe", "8888496629", "dethenikhil7578@gmail.com", medicines, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Customer> customers_1 = new ArrayList<>();
    Customer customer_2 = new Customer(91, "Nikhil", "Dethe", "8888496629", "dethenikhil7578@gmail.com", medicines, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Sales sales_1 = new Sales(3, "2023-06-04", customers, BigDecimal.valueOf(400.25), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Sales sales_2 = new Sales(4, "2023-01-04", customers_1, BigDecimal.valueOf(300.14), "Harshal", "Ramesh", new Date(2000-01-01), new Date(2000-01-01));

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(salesController).build();
    }

    @Test
    public void getAllSales() throws Exception{
        List<Sales> sales = new ArrayList<>(Arrays.asList(sales_1, sales_2));
        Mockito.when(salesRepository.findAll()).thenReturn(sales);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllSales")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    @Test
    public void addSale() throws Exception{
        Sales sales = Sales.builder()
                .id(5)
                .date("2023-01-01")
                .customer((List<Customer>) customers_1)
                .total_cost(BigDecimal.valueOf(300.14))
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

//        Mockito.when(salesRepository.save(sales)).thenReturn(sales);
        String content = objectWriter.writeValueAsString(sales);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertSales")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void updateSales() throws Exception{
        Sales salesUpdate = Sales.builder()
                .id(4)
                .date("2022-04-01")
                .customer((List<Customer>) customers_1)
                .total_cost(BigDecimal.valueOf(300.14))
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(salesRepository.findById(sales_2.getId())).thenReturn(java.util.Optional.ofNullable(sales_2));
//        Mockito.when(salesRepository.save(salesUpdate)).thenReturn(salesUpdate);

        String upContent = objectWriter.writeValueAsString(salesUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateSales")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    @Test
    public void deleteSales() throws Exception{
//        Mockito.when(salesRepository.findById(sales_2.getId())).thenReturn(Optional.of(sales_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteSales/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
