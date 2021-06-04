 package Kodlama.io.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.business.abstracts.JobSekeerService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.ErrorResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.Hrms.core.utilities.results.SuccessResult;
import Kodlama.io.Hrms.core.validations.EmailSendService;
import Kodlama.io.Hrms.core.validations.FakeMernisService;
import Kodlama.io.Hrms.dataAccess.abstracts.JobSekeerDao;
import Kodlama.io.Hrms.dataAccess.abstracts.UserDao;
import Kodlama.io.Hrms.entities.concretes.JobSekeer;

@Service
public class JobSekeerManager implements JobSekeerService {

	private JobSekeerDao jobSekeerDao;
	private UserDao userDao;
	private EmailSendService emailSendService;
	private FakeMernisService fakeMernisService;
	


	@Autowired
	public JobSekeerManager(JobSekeerDao jobSekeerDao, UserDao userDao, EmailSendService emailSendService,
			FakeMernisService fakeMernisService) {
		super();
		this.jobSekeerDao = jobSekeerDao;
		this.userDao = userDao;
		this.emailSendService = emailSendService;
		this.fakeMernisService = fakeMernisService;
	}

	@Override
	public DataResult<List<JobSekeer>> getAll() {
		return new SuccessDataResult<List<JobSekeer>>(this.jobSekeerDao.findAll(), "Data listelendi");

	}

	@Override
	public Result add(JobSekeer jobSeeker) {
		
		
	
		if (jobSeeker.getEmail() == null || jobSeeker.getPassword() == null || jobSeeker.getPasswordRepeat() == null
				|| jobSeeker.getFirstName() == null || jobSeeker.getLastName() == null
				|| jobSeeker.getDateOfBirth() == null || jobSeeker.getNationalIdentity() == null) {

			return new ErrorResult("Tüm alanları doldurunuz");

		}
		if(fakeMernisService.fakeMernisSend(jobSeeker)==false) {
			
			return new ErrorResult("Tc kimlik no 11 haneli olmalıdır. ");
		
	}
		
		
		
		if(!jobSeeker.getPassword().equals(jobSeeker.getPasswordRepeat())) {
			
			return new ErrorResult("Şifreler uyumsuz");
			
			
		}
		if(userDao.findByEmail(jobSeeker.getEmail()) !=null) {
			
			return new ErrorResult("Aynı mail adresi kullanılmaktadır");
			
		}
		if ( jobSekeerDao.findByNationalIdentityIs(jobSeeker.getNationalIdentity()) != null ) {
			return new ErrorResult("Aynı TC Kimlik No kullanılmaktadır");
		}
		
		if(jobSekeerDao.findByEmailIs(jobSeeker.getEmail()) !=null) {
			return new ErrorResult("Bu e posta kullanılmaktadır");
		}
		
		if(emailSendService.emailSend(jobSeeker)==false) {
			
			return new ErrorResult("E posta adresiniz e posta formatında olmalıdır.");
		}
		
		jobSekeerDao.save(jobSeeker);
		return new SuccessResult("İş Arayan Kullanıcı eklendi. Kaydın tamamlanması için doğrulama kodu gönderildi. ");

//else {
//			
//			if( emailSendService.emailSend(jobSeeker) ) {
//				jobSekeerDao.save(jobSeeker);
//				return new SuccessResult("İş Arayan Kullanıcı eklendi. Kaydın tamamlanması için doğrulama kodu gönderildi. ");
//			}
//			else {
//				return new ErrorResult("E posta adresiniz e posta formatında olmalıdır.");
//			}
//			
//		}
	}
}

