package com.goldenrace.exercise.interfazService;

import java.util.Optional;

import com.goldenrace.exercise.model.TicketLine;

public interface ITicketLineService {
	public Optional<TicketLine> listByTicketId(int ticketID);

}
