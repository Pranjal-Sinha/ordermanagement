package com.cloudbees.demo.ControllerTests;

import com.cloudbees.demo.Controller.OrderController;
import com.cloudbees.demo.Service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testCreateOrder() throws Exception {
        when(orderService.createOrder("Pranjal", "Sinha", "pran@example.com")).thenReturn(ResponseEntity.ok("Order created successfully"));

        mockMvc.perform(post("/create")
                        .param("firstName", "Pranjal")
                        .param("lastName", "Sinha")
                        .param("email", "pran@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order created successfully"));
    }
}