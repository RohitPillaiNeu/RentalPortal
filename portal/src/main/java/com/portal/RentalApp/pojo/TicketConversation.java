package com.portal.RentalApp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TicketConversation")
public class TicketConversation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tMessageid")
	private int tMessageid;

	@Column(name = "message")
	private String message;

	@Column(name = "time")
	private String time;

	@Column(name = "date")
	private String date;
	
	@ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;
//
//    @ManyToOne
//    @JoinColumn(name = "receiver_id")
//    private User receiver;
	
	@ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
	
	public TicketConversation() {}

	public int gettMessageid() {
		return tMessageid;
	}

	public void settMessageid(int tMessageid) {
		this.tMessageid = tMessageid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
}
