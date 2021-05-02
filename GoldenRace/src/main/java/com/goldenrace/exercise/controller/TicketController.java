package com.goldenrace.exercise.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goldenrace.exercise.interfaces.ITicket;
import com.goldenrace.exercise.interfazService.ITicketService;
import com.goldenrace.exercise.model.Ticket;

@Controller
@RequestMapping
public class TicketController {
	
	@Autowired
	private ITicketService service;
	
	@Autowired ITicket otherService;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Ticket>tickets=service.list();
		model.addAttribute("tickets", tickets);
		return "index";
	}
	
	@GetMapping("/searchbyid")
	public String searchById(@RequestParam(value="id", required=false, defaultValue="") Integer id, Model model) {
		if(id==null) {
			List<Ticket>tickets=service.list();
			model.addAttribute("tickets", tickets);
		} else {
			Optional<Ticket>ticket=service.listById(id);
			if(ticket.isPresent()) {
				model.addAttribute("tickets", ticket.get());
			} else {
				model.addAttribute("message", "Empty");
			}
		}
		return "index";
	}
	
	@GetMapping("/searchbydate")
	public String searchByDate(@RequestParam(value = "from", required=false, defaultValue="") Date dateFrom, @RequestParam(value = "to", required=false, defaultValue="") Date dateTo, Model model) {
		List<Ticket>tickets=otherService.searchBetweenDate(dateFrom, dateTo);
		if(tickets.isEmpty()) {
			model.addAttribute("message", "Empty");
		} else {
			model.addAttribute("tickets", tickets);
		}
		return "index";
		
	}
}
