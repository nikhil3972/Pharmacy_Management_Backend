package com.manager.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.manager.demo.entity.Manufacturer;
import com.manager.demo.entity.Medicine;
import com.manager.demo.entity.PurchaseOrder;
import com.manager.demo.repository.PurchaseOrderRepository;
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
 * This class contains unit tests for the PurchaseOrderController class.
 */
@RunWith(MockitoJUnitRunner.class)
public class PurchaseOrderControllerTest {

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    PurchaseOrderRepository purchaseOrderRepository;

    @InjectMocks
    PurchaseOrderController purchaseOrderController;

    List<Medicine> medicines = new ArrayList<>();
    Medicine medicine = new Medicine(55, "Vicks", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Medicine> medicinesOne = new ArrayList<>();
    Medicine medicineOne = new Medicine(56, "Capsol", "Cold", "3 times a day", BigDecimal.valueOf(13.45), new Date(2000-01-01), new Date(2001-03-10), 35, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Manufacturer> manufacturers = new ArrayList<>();
    Manufacturer manufacturer = new Manufacturer(61, "Tesla", "8543643478", medicines, "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    List<Manufacturer> manufacturersOne = new ArrayList<>();
    Manufacturer manufacturerOne = new Manufacturer(62, "Cisco", "7478287379", medicinesOne, "Nagesh", "Rahul", new Date(2000-01-01), new Date(2000-01-01));

    PurchaseOrder purchaseOrderOne = new PurchaseOrder(68, new Date(2000-01-01), manufacturers, new Date(2000-01-01), BigDecimal.valueOf(323.67), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    PurchaseOrder purchaseOrderTwo = new PurchaseOrder(69, new Date(2010-01-01), manufacturersOne, new Date(2000-01-01), BigDecimal.valueOf(23.67), "Nikhil", "Abhi", new Date(2000-01-01), new Date(2000-01-01));

    /**
     * Set up method to initialize mock objects and create the mockMvc instance for testing the PurchaseOrderController.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(purchaseOrderController).build();
    }

    /**
     * Test method to verify the getAllPurchaseOrder() method in the PurchaseOrderController class.
     * @throws Exception when there is an error in performing the test request
     */
    @Test
    public void getAllPurchaseOrder() throws Exception{
        List<PurchaseOrder> purchaseOrder = new ArrayList<>(Arrays.asList(purchaseOrderOne, purchaseOrderTwo));
        Mockito.when(purchaseOrderRepository.findAll()).thenReturn(purchaseOrder);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/getAllPurchaseOrder")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }

    /**
     * Test method to verify the addPurchaseOrder() method in the PurchaseOrderController class.
     * @throws Exception when there is an error in performing the test request
     */
    @Test
    public void addPurchaseOrder() throws Exception{
        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .purchaseId(70)
                .purchaseDate(new Date(2023-02-01))
                .manufacturer((List<Manufacturer>) manufacturers)
                .expectedDeliveryDate(new Date(2023-04-10))
                .totalCost(BigDecimal.valueOf(339.67))
                .createdBy("Harshal")
                .modifiedBy("Amit")
                .createdTimestamp(new Date(2000-01-01))
                .modifiedTimestamp(new Date(2000-01-01))
                .build();

        String content = objectWriter.writeValueAsString(purchaseOrder);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/insertPurchaseOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * Test method to verify the updatePurchaseOrder() method in the PurchaseOrderController class.
     * @throws Exception when there is an error in performing the test request
     */
    @Test
    public void updatePurchaseOrder() throws Exception{
        PurchaseOrder purchaseOrderUpdate = PurchaseOrder.builder()
                .purchaseId(69)
                .purchaseDate(new Date(2023-02-01))
                .manufacturer((List<Manufacturer>) manufacturersOne)
                .expectedDeliveryDate(new Date(2023-04-10))
                .totalCost(BigDecimal.valueOf(249.67))
                .createdBy("Harshal")
                .modifiedBy("Amit")
                .createdTimestamp(new Date(2000-01-01))
                .modifiedTimestamp(new Date(2000-01-01))
                .build();

        Mockito.when(purchaseOrderRepository.findById(purchaseOrderTwo.getId())).thenReturn(java.util.Optional.ofNullable(purchaseOrderTwo));

        String upContent = objectWriter.writeValueAsString(purchaseOrderUpdate);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/updatePurchaseOrder")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(upContent);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    /**
     * Test method to verify the deletePurchaseOrder() method in the PurchaseOrderController class.
     * @throws Exception when there is an error in performing the test request
     */
    @Test
    public void deletePurchaseOrder() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/deletePurchaseOrder/69")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
