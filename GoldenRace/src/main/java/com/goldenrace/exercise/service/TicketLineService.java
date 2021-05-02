package com.goldenrace.exercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.goldenrace.exercise.interfaces.ITicketLine;
import com.goldenrace.exercise.interfazService.ITicketLineService;
import com.goldenrace.exercise.model.Ticket;
import com.goldenrace.exercise.model.TicketLine;

public class TicketLineService implements ITicketLineService  {
	
	@Autowired
	private ITicketLine data;

	@Override
	public Optional<TicketLine> listByTicketId(int ticketID) {
		return data.findById(ticketID);
	}

}
