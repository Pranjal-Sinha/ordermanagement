package com.cloudbees.demo.ServiceTests;

import com.cloudbees.demo.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        // Mock any dependencies if needed
        // Example: when(orderRepository.findById(anyLong())).thenReturn(Optional.of(order));

        ResponseEntity<String> response = orderService.createOrder("Pranjal", "Sinha", "pran@example.com");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Order created successfully", response.getBody());
    }
}