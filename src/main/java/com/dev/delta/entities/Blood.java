package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Blood {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="blood_group_id")
	BloodGroup bloodGroup;
	String RemainedBags;
	
	public Blood() {
		// TODO Auto-generated constructor stub
	}

	public Blood(BloodGroup bloodGroup, String remainedBags) {
		super();
		this.bloodGroup = bloodGroup;
		RemainedBags = remainedBags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getRemainedBags() {
		return RemainedBags;
	}

	public void setRemainedBags(String remainedBags) {
		RemainedBags = remainedBags;
	}
	
	
	
}
