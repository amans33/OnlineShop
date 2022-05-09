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
@Table(name="stores")
public class Store {
	
	@Id
	@GeneratedValue
	private BigInteger storeId;
	@Column(nullable=false, length=50)
	private String storeName;
	private String addressLine1;
	private String addressLine2;
	@Column(nullable=false, length=6)
	private Integer pinCode;
	private String city;
	private String state;
	private String country;
	@Column(nullable=false, length=15)
	private String phone;
	@Column(nullable=false, length=50)
	private String email;
	private BigInteger createdBy;
	private BigInteger updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	

}
