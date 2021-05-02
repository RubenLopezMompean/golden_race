package com.goldenrace.exercise.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.goldenrace.exercise.model.TicketLine;

@Repository
public interface ITicketLine extends CrudRepository<TicketLine, Integer> {

}
