package com.portal.RentalApp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Posting")
public class Posting {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "postid")
	private int postid;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "address")
	private String address;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "cost")
	private double cost;
	@Column(name = "isAvailable")
	private boolean isAvailable;
	
	@ManyToOne	
    @JoinColumn(name = "fkuser")
    private User user;
	
	public Posting() {}
	
	
}
