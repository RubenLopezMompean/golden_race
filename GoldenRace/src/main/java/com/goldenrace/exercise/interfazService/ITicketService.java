package com.goldenrace.exercise.interfazService;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.goldenrace.exercise.model.Ticket;

public interface ITicketService {
	public List<Ticket> list();
	public Optional<Ticket>listById(int id);
	
	@Query("SELECT * FROM TICKET WHERE creation_date BETWEEN :startDate AND :endDate")
	public List<Ticket> searchBetweenDate(@Param("startDate")Date dateFrom, @Param("endDate")Date dateTo);

}
