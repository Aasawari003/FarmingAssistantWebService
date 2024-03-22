package com.farming.service;

import org.springframework.stereotype.Service;

import com.farming.models.Product;
import com.farming.models.User;

@Service
public interface ProductService {
    public static Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getfarmerIdByEmail(String email);

	public boolean isUserWithEmailExists(String email);
}
