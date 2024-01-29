package com.Aquademy.restservices.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Aquademy.restservices.entities.Cart;
import com.Aquademy.restservices.entities.User;

public interface CartRepository extends JpaRepository<Cart,Long> {

	Optional<Cart> findByUserUserId(Long userId);
	
}
