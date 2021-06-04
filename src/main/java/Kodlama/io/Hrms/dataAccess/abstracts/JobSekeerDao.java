package Kodlama.io.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Hrms.entities.concretes.JobSekeer;

public interface JobSekeerDao extends JpaRepository<JobSekeer, Integer> {
	
		JobSekeer  findByNationalIdentityIs(String nationalIdentity);
		JobSekeer  findByEmailIs(String email);

}
