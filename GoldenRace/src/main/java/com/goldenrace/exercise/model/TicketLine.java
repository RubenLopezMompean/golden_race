package com.goldenrace.exercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_line")
public class TicketLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lineID;
	private int ticketID;
	private String description;
	private double amount;
	
	public TicketLine() {
		// TODO Auto-generated constructor stub
	}

	public TicketLine(int lineID, int ticketID, String description, double amount) {
		super();
		this.lineID = lineID;
		this.ticketID = ticketID;
		this.description = description;
		this.amount = amount;
	}

	public int getLineID() {
		return lineID;
	}

	public void setLineID(int lineID) {
		this.lineID = lineID;
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
