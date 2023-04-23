package com.portal.RentalApp.pojo;

import java.util.ArrayList;
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
	@Column(name = "imageName")
	private String imageName;
	@Column(name = "isAvailable")
	private boolean isAvailable;
	
	@ManyToOne	
    @JoinColumn(name = "fkuser")
    private User user;
	

	@OneToMany(mappedBy = "posting", cascade = CascadeType.ALL)
    private List<Enquiry> enquiries = new ArrayList<>();
	
	public Posting() {}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Enquiry> getEnquiries() {
		return enquiries;
	}

	public void setEnquiries(List<Enquiry> enquiries) {
		this.enquiries = enquiries;
	}
	
	
}
