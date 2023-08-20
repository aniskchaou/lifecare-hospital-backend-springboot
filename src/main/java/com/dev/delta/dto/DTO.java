package com.dev.delta.dto;

import com.dev.delta.entities.Account;
import com.dev.delta.entities.Ambulance;
import com.dev.delta.entities.Appointement;
import com.dev.delta.entities.Bed;
import com.dev.delta.entities.BedType;
import com.dev.delta.entities.Blood;
import com.dev.delta.entities.BloodDonation;
import com.dev.delta.entities.BloodDonor;
import com.dev.delta.entities.BloodGroup;
import com.dev.delta.entities.Departement;
import com.dev.delta.entities.Diagnosis;
import com.dev.delta.entities.Doctor;
import com.dev.delta.entities.DoctorSpeciality;
import com.dev.delta.entities.Document;
import com.dev.delta.entities.Driver;
import com.dev.delta.entities.Employee;
import com.dev.delta.entities.Expense;
import com.dev.delta.entities.Income;
import com.dev.delta.entities.Insurance;
import com.dev.delta.entities.Inventory;
import com.dev.delta.entities.Laboratorist;
import com.dev.delta.entities.Medecine;
import com.dev.delta.entities.MedecineCategory;
import com.dev.delta.entities.MedecineType;
import com.dev.delta.entities.Nurse;
import com.dev.delta.entities.Patient;
import com.dev.delta.entities.Payment;
import com.dev.delta.entities.Pharmacist;
import com.dev.delta.entities.Prescription;
import com.dev.delta.entities.Radiology;
import com.dev.delta.entities.RadiologyCategory;
import com.dev.delta.entities.RadiologyType;
import com.dev.delta.entities.Recipionist;
import com.dev.delta.entities.Schedule;
import com.dev.delta.entities.Service;
import com.dev.delta.entities.VaccinatedPeople;
import com.dev.delta.entities.Vaccination;

public interface DTO {
	Account account=new Account();
	Ambulance ambulance=new Ambulance(); 
	Appointement appointement=new Appointement();
	Bed bed=new Bed();
	BedType bedType=new BedType();
	Blood blood=new Blood();
	BloodDonation bloodDonation=new BloodDonation();
	BloodDonor bloodDonor=new BloodDonor();
	BloodGroup bloodGroup=new BloodGroup();
	Departement departement=new Departement();
	Diagnosis diagnosis=new Diagnosis();
	Doctor doctor=new Doctor();
	DoctorSpeciality doctorSpeciality=new DoctorSpeciality();
	Document document=new Document();
	Driver driver=new Driver();
	Employee  employee=new Employee();
	Expense expense=new Expense();
	Income income=new Income();
	Insurance insurance=new Insurance();
	Inventory inventory=new Inventory();
	Laboratorist laboratorist=new Laboratorist();
	Medecine medecine=new Medecine();
	MedecineCategory medecineCategory=new MedecineCategory();
	MedecineType medecineType=new MedecineType();
	Nurse nurse=new Nurse();
	Patient patient=new Patient();
	Payment payment=new Payment();
	Pharmacist pharmacist=new Pharmacist();
	Prescription prescription=new Prescription();
	Radiology radiology=new Radiology();
	RadiologyCategory radiologyCategory=new RadiologyCategory();
	RadiologyType radiologyType=new RadiologyType();
	Recipionist recipionist=new Recipionist();
	Schedule schedule=new Schedule();
	Service service=new Service();
	VaccinatedPeople  vaccinatedPeople=new VaccinatedPeople();
	Vaccination vaccination=new Vaccination();
	
	

	public void populate();
}
