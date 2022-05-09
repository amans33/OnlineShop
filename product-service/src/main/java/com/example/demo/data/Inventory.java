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
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue
	private BigInteger inventoryId;
	private BigInteger productId;
	private BigInteger storeId;
	private Long quantity;
	private BigInteger createdBy;
	private BigInteger updatedBy;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	

}
