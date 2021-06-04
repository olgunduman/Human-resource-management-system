package Kodlama.io.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Hrms.business.abstracts.JobAdvertisementService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.entities.concretes.Employer;
import Kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/JobAdvertisement")
public class JobAdvertisementController {

	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	 
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
		

		
	@GetMapping("/getByApplicationDeadline")
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndApplicationDeadline(){
		return this.jobAdvertisementService.findByIsActiveOrderByReleaseDate();
	} 
	
	@GetMapping("/findByEmployer_CompanyName")
	public DataResult<List<JobAdvertisementDto>>findByEmployer_CompanyName(@RequestParam("companyName") String companyName){
		
		return this.jobAdvertisementService.findByEmployer_CompanyName(companyName);
	}
	
	@GetMapping("/findByIsActive")
	public DataResult<List<JobAdvertisementDto>> findByIsActive(){
		
		return this.jobAdvertisementService.findByIsActive();
	}
		
		
} 
