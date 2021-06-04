package Kodlama.io.Hrms.business.abstracts;

import java.util.List;

import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.entities.concretes.Employer;
import Kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {

	 Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByReleaseDate();
	
	DataResult<List<JobAdvertisementDto>>findByEmployer_CompanyName(String companyName);
	
	DataResult<List<JobAdvertisementDto>> findByIsActive();
}
