package Kodlama.io.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Hrms.business.abstracts.JobPositionService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.entities.concretes.JobPosition;

@RestController // : sen bir controllersın demek
@RequestMapping("/api/jobpositions") 
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>>  getAll(){
		 
		return this.jobPositionService.getAll();
	}

}
