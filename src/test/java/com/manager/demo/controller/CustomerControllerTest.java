package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Customer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.repository.CustomerRepository;
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
 * JUnit test class for CustomerController.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerController customerController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(35, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicines_1 = new ArrayList<>();
    Medicine medicine_1 = new Medicine(36, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    Customer customer_1 = new Customer(15, "Nikhil", "Dethe", "8888496629", "dethenikhil7578@gmail.com", medicines, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));
    Customer customer_2 = new Customer(16, "Amit", "Shinde", "9766107234", "ams941@gmail.com", medicines_1, new Date(2001-06-04), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    /**
     * Set up method to initialize the mock objects and the MockMvc instance.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    /**
     * Test method for getting all customers from the repository.
     * @throws Exception if an error occurs while performing the request.
     */
    @Test
    public void getAllCustomers() throws Exception{
        List<Customer> customers = new ArrayList<>(Arrays.asList(customer_1, customer_2));
        Mockito.when(customerRepository.findAll()).thenReturn(customers);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllCustomer")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    /**
     * Test method for adding a customer to the repository.
     * @throws Exception if an error occurs while performing the request.
     */
    @Test
    public void addCustomer() throws Exception{
        Customer customer = Customer.builder()
                .id(17)
                .firstName("Ganesh")
                .lastName("Chormale")
                .contact("8328528894")
                .email("ganesh123@gmail.com")
                .medicine((List<Medicine>) medicines)
                .dob(new Date(2000-01-01))
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        String content = objectWriter.writeValueAsString(customer);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    /**
     * Test method for updating a customer record in the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void updateCustomer() throws Exception{
        Customer customerUpdate = Customer.builder()
                .id(16)
                .firstName("Amit")
                .lastName("Jadhav")
                .contact("8328528894")
                .email("ganesh123@gmail.com")
                .medicine((List<Medicine>) medicines)
                .dob(new Date(2000-01-01))
                .created_by("Harshal")
                .modified_by("Amit")
                .created_ts(new Date(2000-01-01))
                .modified_ts(new Date(2000-01-01))
                .build();

        Mockito.when(customerRepository.findById(customer_2.getId())).thenReturn(java.util.Optional.ofNullable(customer_2));
//        Mockito.when(customerRepository.save(customerUpdate)).thenReturn(customerUpdate);

        String upContent = objectWriter.writeValueAsString(customerUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updateCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$", notNullValue()));
    }

    /**
     * Test method for deleting a customer record from the database.
     * @throws Exception if there is an error performing the test
     */
    @Test
    public void deleteCustomer() throws Exception{
//        Mockito.when(customerRepository.findById(customer_2.getId())).thenReturn(Optional.of(customer_2));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deleteCustomer/16")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}