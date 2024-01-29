package com.Aquademy.restservices.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aquademy.restservices.dtos.CartSummaryDTO;
import com.Aquademy.restservices.dtos.CourseDTO;
import com.Aquademy.restservices.entities.Cart;
import com.Aquademy.restservices.entities.Course;
import com.Aquademy.restservices.entities.User;
import com.Aquademy.restservices.repositories.CartRepository;
import com.Aquademy.restservices.repositories.CourseRepository;
import com.Aquademy.restservices.repositories.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//addCourseToCart
    public Cart addCourseToCart(Long userId, Long courseId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new RuntimeException("Course not found"));

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
            cart.setCourses(new ArrayList<>());
        }

        if (!cart.getCourses().contains(course)) {
            cart.getCourses().add(course);
            cart.setTotal(calculateTotal(cart.getCourses()));
        }

        return cartRepository.save(cart);
    }
    
    
    //removeCourseToCart
    public Cart removeCourseFromCart(Long userId, Long courseId) {
        Cart cart = cartRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Course courseToRemove = cart.getCourses().stream()
                .filter(course -> course.getCourseId().equals(courseId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Course not found in cart"));

        cart.getCourses().remove(courseToRemove);
        cart.setTotal(calculateTotal(cart.getCourses())); // Recalculate total
        return cartRepository.save(cart);
    }
    

    private Double calculateTotal(List<Course> courses) {
        return courses.stream()
            .mapToDouble(Course::getPrice)
            .sum();
    }
    
    
    //SummaryOfContentCart
    public CartSummaryDTO getCartSummary(Long userId) {
        Cart cart = cartRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found for user ID: " + userId));

        CartSummaryDTO summary = new CartSummaryDTO();
        summary.setCartId(cart.getCartId());
        summary.setTotal(cart.getTotal());
        summary.setCourses(cart.getCourses().stream()
                                .map(CourseDTO::new)
                                .collect(Collectors.toList()));
        summary.setNumberOfItems(cart.getCourses().size());

        return summary;
    }


}
