package com.farming.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
@Entity
@Table(name = "Farmer_Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    // Remove the separate userId field as it's redundant
    private String productName;
    private String priceQuantity;
    private String productDescription;
    private String imagePath; // This can be used to store the image path in the database
    private String farmerEmail;// // This will store the email of the farmer who adds the product
    private Integer farmerId; // This will store the ID of the farmer who adds the product

    // Constructors, getters, and setters
    public Product() {
    }

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPriceQuantity() {
		return priceQuantity;
	}

	public void setPriceQuantity(String priceQuantity) {
		this.priceQuantity = priceQuantity;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}

	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public Integer getFarmerId() {
        return farmerId;
    }
	public Product(Integer pid, String productName, String priceQuantity, String productDescription,
			String imagePath, String farmerEmail) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.priceQuantity = priceQuantity;
		this.productDescription = productDescription;
		this.imagePath = imagePath;
		this.farmerEmail = farmerEmail;
	}
	
}