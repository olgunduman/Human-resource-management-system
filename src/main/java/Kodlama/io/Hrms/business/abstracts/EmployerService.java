package Kodlama.io.Hrms.business.abstracts;

import java.util.List;

import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(Employer employer);
}
