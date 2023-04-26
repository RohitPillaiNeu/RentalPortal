package com.portal.RentalApp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "body")
    private String body;
    
    @Column(name = "imagename")	
    private String imageName;
    
    @Column(name = "dateCreated")	
    private String dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Announcement() {
    }

	public Announcement(Long id, String name, String body, String imageName, String dateCreated, User user) {
		super();
		this.id = id;
		this.name = name;
		this.body = body;
		this.imageName = imageName;
		this.dateCreated = dateCreated;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}   	
}
