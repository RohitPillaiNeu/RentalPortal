package com.portal.RentalApp.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ticket")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticketid")
	private int ticketid;

	@Column(name = "isResolved")
	private boolean isResolved;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "priority")
    private int priority;
	
	@Column(name = "createDate")
	private String createDate;

	@Column(name = "resolvedDate")
	private String resolvedDate;
	
	@ManyToOne
    @JoinColumn(name="user_id")
    private User user;

	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketConversation> ticketConversations;
	
	public Ticket() {}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TicketConversation> getTicketConversations() {
		return ticketConversations;
	}

	public void setTicketConversations(List<TicketConversation> ticketConversations) {
		this.ticketConversations = ticketConversations;
	}
	
	
}
