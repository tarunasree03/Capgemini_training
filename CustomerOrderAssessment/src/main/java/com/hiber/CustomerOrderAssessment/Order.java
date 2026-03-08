package com.hiber.CustomerOrderAssessment;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String orderNumber;
	
	@Column
	private String productName;
	
	@Column
	private int quantity;
	
	@Column
	private double price;
	
	@Column
	private LocalDate orderDate;
	
	
	
	@OneToOne(mappedBy = "orders",cascade = CascadeType.ALL )
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public Order() {
		
	}

	public Order(int id, String orderNumber, String productName, int quantity, double price, LocalDate orderDate) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
