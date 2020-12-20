package org.eclipse.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="client_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="order_date")
	private Calendar orderDate;
	
	@Column(name="order_status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="client", insertable = true, updatable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Client client;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id", insertable = true, updatable = true)    
	private List<OrderLine> orderLines;

	public Order() {
		super();
	}
	

	public Order(long id, Calendar orderDate, String status, Client client, List<OrderLine> orderLines) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
		this.client = client;
		this.orderLines = orderLines;
	}
	

	public Order(Calendar orderDate, String status, Client client, List<OrderLine> orderLines) {
		super();
		this.orderDate = orderDate;
		this.status = status;
		this.client = client;
		this.orderLines = orderLines;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}


	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
