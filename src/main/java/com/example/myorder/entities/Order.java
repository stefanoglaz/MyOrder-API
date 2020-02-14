package com.example.myorder.entities;

import com.example.myorder.enums.OrderStatusEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="USER_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "TOTAL_VALUE")
	@NotNull
	private BigDecimal totalValue;

	@Column(name = "STATUS")
	@NotNull
	private OrderStatusEnum status;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "RESTAURANT_ID")
	private Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@OrderBy("id ASC")
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderProduct> productList;

	public List<OrderProduct> getProductList() {
		return productList;
	}

	public Order setProductList(List<OrderProduct> productList) {
		this.productList = productList;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public Order setId(Integer id) {
		this.id = id;
		return this;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public Order setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
		return this;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public Order setStatus(OrderStatusEnum status) {
		this.status = status;
		return this;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public Order setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Order setUser(User user) {
		this.user = user;
		return this;
	}
}
