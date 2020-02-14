package com.example.myorder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ORDER_PRODUCT")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USER_ORDER_ID")
	@NotNull
	private Order order;

	@Column(name =  "QUANTITY")
	@NotNull
	@Min( value = 1)
	private Integer quantity;

	@ManyToOne
	@Column(name =  "PRODUCT")
	@NotNull
	private Product product;

	public Integer getId() {
		return id;
	}

	public OrderProduct setId(Integer id) {
		this.id = id;
		return this;
	}

	public Order getOrder() {
		return order;
	}

	public OrderProduct setOrder(Order order) {
		this.order = order;
		return this;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public OrderProduct setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public OrderProduct setProduct(Product product) {
		this.product = product;
		return this;
	}
}
