package com.goldenrace.exercise.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date creation_date;
	private double total_amount;

	@OneToMany(targetEntity = TicketLine.class, cascade = CascadeType.ALL)
	@JoinColumn(name="ticketid")
	private List<TicketLine> details;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	public Ticket(int id, Date creation_date, double total_amount, List<TicketLine> details) {
		super();
		this.id = id;
		this.creation_date = creation_date;
		this.total_amount = total_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public List<TicketLine> getDetails() {
		return details;
	}

	public void setDetails(List<TicketLine> details) {
		this.details = details;
	}
	
}
