package com.cloudbees.demo.Controller;

import com.cloudbees.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the Order Management System!";
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        return orderService.createOrder(firstName, lastName, email);
    }

    @GetMapping("/invoice/{email}")
    public ResponseEntity<String> viewInvoice(@PathVariable String email) {
        return orderService.viewInvoice(email);
    }

    @GetMapping("/orders/{status}")
    public ResponseEntity<String> viewOrdersByStatus(@PathVariable String status) {
        return orderService.viewOrdersByStatus(status);
    }

    @DeleteMapping("/cancel/{email}")
    public ResponseEntity<String> cancelOrder(@PathVariable String email) {
        return orderService.cancelOrder(email);
    }

    @PutMapping("/modify-details/{email}")
    public ResponseEntity<String> modifyOrderDetails(@PathVariable String email, @RequestParam String newDetails) {
        return orderService.modifyOrderDetails(email, newDetails);
    }
}