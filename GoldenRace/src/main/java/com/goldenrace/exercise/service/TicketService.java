package com.goldenrace.exercise.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenrace.exercise.interfaces.ITicket;
import com.goldenrace.exercise.interfazService.ITicketService;
import com.goldenrace.exercise.model.Ticket;

@Service
public class TicketService implements ITicketService {

	@Autowired
	private ITicket data;
	
	@Override
	public List<Ticket> list() {
		return (List<Ticket>)data.findAll();
	}

	@Override
	public Optional<Ticket> listById(int id) {
		return data.findById(id);
	}

	@Override
	public List<Ticket> searchBetweenDate(Date dateFrom, Date dateTo) {
		return searchBetweenDate(dateFrom, dateTo);
	}

}
