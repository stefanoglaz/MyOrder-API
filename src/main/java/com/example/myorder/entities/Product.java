package com.example.myorder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Column(name = "VALUE")
	private BigDecimal value;

	@NotNull
	@ManyToOne
	@JoinColumn(name="RESTAURANT_ID")
	private Restaurant restaurant;

	public Integer getId() {
		return id;
	}

	public Product setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Product setName(String name) {
		this.name = name;
		return this;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Product setValue(BigDecimal value) {
		this.value = value;
		return this;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Product setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
		return this;
	}
}
