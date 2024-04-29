package com.cloudbees.demo.Service;

import com.cloudbees.demo.Model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {

    private static Map<String, Order> orders = new HashMap<>();

    public ResponseEntity<String> createOrder(String firstName, String lastName, String email) {
        Order order = new Order(firstName, lastName, email);
        orders.put(email, order);
        return ResponseEntity.ok("Order created successfully.");
    }

    public ResponseEntity<String> viewInvoice(String email) {
        if (orders.containsKey(email)) {
            return ResponseEntity.ok(orders.get(email).toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
    }

    public ResponseEntity<String> viewOrdersByStatus(String status) {
        // Implement logic to retrieve orders by status if needed
        return ResponseEntity.ok("Orders by status: " + status);
    }

    public ResponseEntity<String> cancelOrder(String email) {
        if (orders.containsKey(email)) {
            orders.remove(email);
            return ResponseEntity.ok("Order canceled successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
    }

    public ResponseEntity<String> modifyOrderDetails(String email, String newDetails) {
        if (orders.containsKey(email)) {
            Order order = orders.get(email);
            order.setDetails(newDetails);
            return ResponseEntity.ok("Order details modified successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
    }
}