package Kodlama.io.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.business.abstracts.JobPositionService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.Hrms.dataAccess.abstracts.JobPositionDao;
import Kodlama.io.Hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>>getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Data listelendi");
	}

}
