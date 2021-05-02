package com.goldenrace.exercise.interfaces;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goldenrace.exercise.model.Ticket;

@Repository
public interface ITicket extends CrudRepository<Ticket, Integer> {

	@Query(value="SELECT * FROM TICKET WHERE creation_date BETWEEN :startDate AND :endDate", nativeQuery=true)
	List<Ticket> searchBetweenDate(@Param("startDate")Date dateFrom, @Param("endDate")Date dateTo);
	
}
