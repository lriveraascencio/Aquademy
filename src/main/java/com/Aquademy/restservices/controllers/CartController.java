package com.Aquademy.restservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Aquademy.restservices.dtos.CartSummaryDTO;
import com.Aquademy.restservices.dtos.OrderDTO;
import com.Aquademy.restservices.entities.Cart;
import com.Aquademy.restservices.services.CartService;
import com.Aquademy.restservices.services.OrderService;

@RestController
@RequestMapping(value="/api/cart")
public class CartController {
	
	@Autowired
    private CartService cartService;
	
	@Autowired
	private OrderService orderService;

	
	//addCourseToCart
	@PostMapping("/{userId}/addCourse")
    public ResponseEntity<?> addCourseToCart(@PathVariable Long userId, @RequestBody Long courseId) {
        try {
            Cart updatedCart = cartService.addCourseToCart(userId, courseId);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	
	//removeCourseToCart
	@DeleteMapping("/{userId}/removeCourse/{courseId}")
    public ResponseEntity<?> removeCourseFromCart(@PathVariable Long userId, @PathVariable Long courseId) {
        try {
            Cart updatedCart = cartService.removeCourseFromCart(userId, courseId);
            return ResponseEntity.ok(updatedCart);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	//SummaryOfContentCart
	@GetMapping("/{userId}/summary")
    public ResponseEntity<?> getCartSummary(@PathVariable Long userId) {
        try {
            CartSummaryDTO cartSummary = cartService.getCartSummary(userId);
            return ResponseEntity.ok(cartSummary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
	
	//checkout
    @PostMapping("/{userId}/checkout")
    public ResponseEntity<?> checkoutCart(@PathVariable Long userId) {
        try {
            OrderDTO order = orderService.checkout(userId);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
	
}
