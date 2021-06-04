package Kodlama.io.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.business.abstracts.JobAdvertisementService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.Hrms.core.utilities.results.SuccessResult;
import Kodlama.io.Hrms.dataAccess.abstracts.JobAdvertisementDao;

import Kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto;
@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	
	private JobAdvertisementDao jobAdvertisementDao;
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi");
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByReleaseDate() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveOrderByReleaseDate(),"data listed");
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> findByEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByEmployer_CompanyName(companyName),"data listed");
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByIsActiveTrue(),"data listed");
		
	}

	
	

	
	
	
	

}
