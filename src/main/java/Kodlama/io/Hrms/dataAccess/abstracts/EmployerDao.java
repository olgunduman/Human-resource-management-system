package Kodlama.io.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Hrms.entities.concretes.Employer;



public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
	Employer findByEmail(String email);
	Employer findByWebSite(String webSite);
	Employer findByTelefoneNumber(String telefoneNumber);

	

}
