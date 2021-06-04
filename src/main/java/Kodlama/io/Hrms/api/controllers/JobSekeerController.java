package Kodlama.io.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Hrms.business.abstracts.JobSekeerService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.entities.concretes.JobSekeer;

@RestController
@RequestMapping("/api/jobsekeer")
public class JobSekeerController {
	
	private JobSekeerService jobSekeerService;

		@Autowired
	public JobSekeerController(JobSekeerService jobSekeerService) {
		super();
		this.jobSekeerService = jobSekeerService;
	}
		@GetMapping("/getall")
		public DataResult<List<JobSekeer>> getAll() { 
			return this.jobSekeerService.getAll();
		}
		
		@PostMapping
		public Result add(@RequestBody JobSekeer jobSeekerUser) {
			return this.jobSekeerService.add(jobSeekerUser);
		}
}
