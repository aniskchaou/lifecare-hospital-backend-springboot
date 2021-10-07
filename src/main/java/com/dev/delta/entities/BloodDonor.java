package com.dev.delta.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class BloodDonor {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String firstName;
	String lastName;
	String Age;
	String Gender; 
	@ManyToOne
	@JoinColumn(name="blood_group_id")
	BloodGroup bloodGroup;
	String LastDonationDate;
	
	public BloodDonor() {
		// TODO Auto-generated constructor stub
	}

	public BloodDonor(String firstName, String lastName, String age, String gender, BloodGroup bloodGroup,
			String lastDonationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Age = age;
		Gender = gender;
		this.bloodGroup = bloodGroup;
		LastDonationDate = lastDonationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getLastDonationDate() {
		return LastDonationDate;
	}

	public void setLastDonationDate(String lastDonationDate) {
		LastDonationDate = lastDonationDate;
	}
	
	
}
