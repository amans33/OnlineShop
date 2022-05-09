package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue
	private BigInteger productId;
	@Column(nullable=false, length=50)
	private String productName;
	private String productShortDescription;
	private String productDescription;
	private String brand;
	@Column(nullable = false)
	private Integer price;
	private Boolean isActive;
	private BigInteger createdBy;
	private BigInteger updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	

}
