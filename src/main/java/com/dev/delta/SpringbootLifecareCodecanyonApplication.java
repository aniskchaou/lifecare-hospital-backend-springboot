package com.dev.delta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dev.delta.dto.AccountDTO;
import com.dev.delta.dto.AmbulanceDTO;
import com.dev.delta.dto.AppointementDTO;
import com.dev.delta.dto.BedDTO;
import com.dev.delta.dto.BedTypeDTO;
import com.dev.delta.dto.BloodDTO;
import com.dev.delta.dto.BloodDonationDTO;
import com.dev.delta.dto.BloodDonorDTO;
import com.dev.delta.dto.BloodGroupDTO;
import com.dev.delta.dto.DepartementDTO;
import com.dev.delta.dto.DiagnosisDTO;
import com.dev.delta.dto.DoctorDTO;
import com.dev.delta.dto.DriverDTO;
import com.dev.delta.dto.ExpenseDTO;
import com.dev.delta.dto.IncomeDTO;
import com.dev.delta.dto.InventoryDTO;
import com.dev.delta.dto.MedecineCategoryDTO;
import com.dev.delta.dto.MedecineDTO;
import com.dev.delta.dto.MedecineTypeDTO;
import com.dev.delta.dto.NurseDTO;
import com.dev.delta.dto.PatientDTO;
import com.dev.delta.dto.RadiologyCategoryDTO;
import com.dev.delta.dto.RadiologyDTO;
import com.dev.delta.dto.RadiologyTypeDTO;
import com.dev.delta.dto.RecipionistDTO;
import com.dev.delta.dto.ServiceDTO;
import com.dev.delta.dto.VaccinatedPeopleDTO;
import com.dev.delta.dto.VaccinationDTO;


@ComponentScan({"com.dev.delta.controllers", "com.dev.delta.security","com.dev.delta.services", "com.dev.delta.dto" }) // to scan repository files
@EntityScan("com.dev.delta.entities")
@EnableJpaRepositories("com.dev.delta.repositories")
@SpringBootApplication
public class SpringbootLifecareCodecanyonApplication implements CommandLineRunner {

	@Autowired
	ExpenseDTO expenseDTO;
	
	@Autowired
	PatientDTO patientDTO;
	
	@Autowired
	DoctorDTO doctorDTO;
	
	@Autowired
	AccountDTO  accountDTO;
	
	@Autowired
	AmbulanceDTO ambulanceDTO;
	
	@Autowired
	AppointementDTO appointementDTO;
	
	@Autowired
	BedDTO bedDTO;
	
	@Autowired
	BedTypeDTO bedTypeDTO;
	
	@Autowired
	BloodDonationDTO bloodDonationDTO;
	
	@Autowired
	BloodDonorDTO bloodDonorDTO;
	
	@Autowired
	BloodDTO bloodDTO;
	
	@Autowired
	BloodGroupDTO bloodGroupDTO;
	
	@Autowired
	DepartementDTO departementDTO;
	
	@Autowired
	DiagnosisDTO diagnosisDTO;
	
	@Autowired
	DriverDTO driverDTO;
	
	@Autowired
	IncomeDTO incomeDTO;
	
	@Autowired
	InventoryDTO inventoryDTO;
	
	@Autowired
	MedecineCategoryDTO medecineCategoryDTO;
	
	@Autowired
	MedecineDTO medecineDTO;
	
	@Autowired
	MedecineTypeDTO medecineTypeDTO;
	
	@Autowired
	NurseDTO nurseDTO;
	
	@Autowired
	RadiologyCategoryDTO radiologyCategoryDTO;
	
	@Autowired
	RadiologyDTO radiologyDTO;
	
	@Autowired
	RadiologyTypeDTO radiologyTypeDTO;
	
	@Autowired
	RecipionistDTO recipionistDTO;
	
	@Autowired
	ServiceDTO serviceDTO;
	
	@Autowired
	VaccinatedPeopleDTO vaccinatedPeopleDTO;
	
	@Autowired
	VaccinationDTO vaccinationDTO;
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootLifecareCodecanyonApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		patientDTO.populate();
		doctorDTO.populate();
		//diagnosisDTO.populate();
		driverDTO.populate();
		expenseDTO.populate();
		
		
		appointementDTO.populate();
		ambulanceDTO.populate();
		accountDTO.populate();
		bedTypeDTO.populate();
		bedDTO.populate();
		
		bloodGroupDTO.populate();
		bloodDonorDTO.populate();
		bloodDonationDTO.populate();
		
		bloodDTO.populate();
		doctorDTO.populate();
		departementDTO.populate();
		
		
		
		incomeDTO.populate();
		inventoryDTO.populate();
		medecineDTO.populate();
		medecineCategoryDTO.populate();
		medecineTypeDTO.populate();
		nurseDTO.populate();
		
		radiologyCategoryDTO.populate();
		radiologyTypeDTO.populate();
		radiologyDTO.populate();
		
		recipionistDTO.populate();
		serviceDTO.populate();
		vaccinatedPeopleDTO.populate();
		vaccinationDTO.populate();
		
	}

}
