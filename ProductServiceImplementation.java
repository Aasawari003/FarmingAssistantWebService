package com.farming.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farming.models.Product;
import com.farming.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImplementation  implements ProductService {

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

	@Override
	public Long getfarmerIdByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserWithEmailExists(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	
}