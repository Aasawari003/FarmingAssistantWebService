package com.farming.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farming.models.Product;
import com.farming.models.User;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}