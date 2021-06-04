package Kodlama.io.Hrms.business.abstracts;

import java.util.List;

import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.entities.concretes.JobSekeer;

public interface JobSekeerService {
	DataResult<List<JobSekeer>> getAll();
	Result add(JobSekeer jobSeeker);
}
