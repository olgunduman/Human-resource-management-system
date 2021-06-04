package Kodlama.io.Hrms.core.validations;


import Kodlama.io.Hrms.entities.concretes.JobSekeer;

public interface MernisValidationService {

	 boolean checkIfRealPerson(JobSekeer jobSekeer);
}
