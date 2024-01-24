package com.Aquademy.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Aquademy.restservices.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
