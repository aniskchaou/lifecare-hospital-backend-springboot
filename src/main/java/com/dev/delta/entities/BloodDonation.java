package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class BloodDonation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne
	@JoinColumn(name="donor_id")
	BloodDonor DonorName;
	String bags;
	
	public BloodDonation() {
		// TODO Auto-generated constructor stub
	}
	
	

	public BloodDonation(BloodDonor donorName, String bags) {
		super();
		DonorName = donorName;
		this.bags = bags;
	}



	public BloodDonor getDonorName() {
		return DonorName;
	}

	public void setDonorName(BloodDonor donorName) {
		DonorName = donorName;
	}

	public String getBags() {
		return bags;
	}

	public void setBags(String bags) {
		this.bags = bags;
	}
	
}
