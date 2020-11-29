package org.eclipse.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="client_order")
public class Order {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="order_date")
	private Calendar orderDate;
	
	@Column(name="order_status")
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="client") 
	private Client client;
	
	@OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	@JsonBackReference(value="client")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@JsonManagedReference(value="order")
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}


	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	
}
