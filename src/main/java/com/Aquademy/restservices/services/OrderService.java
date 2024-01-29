package com.Aquademy.restservices.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aquademy.restservices.dtos.OrderDTO;
import com.Aquademy.restservices.entities.Cart;
import com.Aquademy.restservices.entities.Order;
import com.Aquademy.restservices.repositories.CartRepository;
import com.Aquademy.restservices.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
    public OrderDTO checkout(Long userId) {
        Cart cart = cartRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

        if (cart.getCourses().isEmpty()) {
            throw new RuntimeException("Cannot checkout an empty cart");
        }

        Order order = new Order();
        order.setUser(cart.getUser());
        order.setCourses(new ArrayList<>(cart.getCourses()));;
        order.setDate(new Date()); // Set the current date as the order date
        order.setTotal(cart.getTotal());
        
        order = orderRepository.save(order);

        // Clear the cart
        cart.getCourses().clear();
        cart.setTotal(0.0);
        cartRepository.save(cart);

        return new OrderDTO(order); // Assuming OrderDTO has a constructor that takes an Order entity
    }

}
