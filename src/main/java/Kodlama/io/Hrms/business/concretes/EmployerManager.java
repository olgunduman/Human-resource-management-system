 package Kodlama.io.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.business.abstracts.EmployerService;
import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.core.utilities.results.ErrorResult;
import Kodlama.io.Hrms.core.utilities.results.Result;
import Kodlama.io.Hrms.core.utilities.results.SuccessDataResult;
import Kodlama.io.Hrms.core.utilities.results.SuccessResult;
import Kodlama.io.Hrms.core.validations.EmailSendService;
import Kodlama.io.Hrms.core.validations.SystemPersonelValidationService;
import Kodlama.io.Hrms.dataAccess.abstracts.EmployerDao;
import Kodlama.io.Hrms.dataAccess.abstracts.UserDao;
import Kodlama.io.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private UserDao userDao;
	private EmployerDao employerDao;
	private EmailSendService emailSendService;
	private SystemPersonelValidationService systemPersonelValidationService;

	@Autowired
	public EmployerManager(UserDao userDao, EmployerDao employerDao, EmailSendService emailSendService,
			SystemPersonelValidationService systemPersonelValidationService) {
		super();
		this.userDao = userDao;
		this.employerDao = employerDao;
		this.emailSendService = emailSendService;
		this.systemPersonelValidationService = systemPersonelValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if (employer.getCompanyName().isEmpty() && employer.getWebSite().isEmpty()
				&& employer.getTelefoneNumber().isEmpty() && employer.getEmail().isEmpty()
				&& employer.getPassword().isEmpty() && employer.getPasswordRepeat().isEmpty()) {

			return new ErrorResult("Tüm alanlar zorunludur.");

		}
		
		if(systemPersonelValidationService.systemPersonelVadalidation()!=true) {
			
			return new ErrorResult("Hata : System personeli tarafından doğrulama gerçekleştirilemedi.");
		}
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {

			return new ErrorResult("Şifreler uyumsuz");
		}
		if (userDao.findByEmail(employer.getEmail()) != null) {

			return new ErrorResult("E posta adresi kullanılmaktadır.");

		}
		if (employerDao.findByTelefoneNumber(employer.getTelefoneNumber()) != null) {

			return new ErrorResult("Aynı Telefon numarası kullanılmaktadır.");

		}
		if (employerDao.findByWebSite(employer.getEmail()) != null) {

			return new ErrorResult("Web Site adresi kullanılmaktadır.");

		}
		if(emailSendService.emailSend(employer)!=true) {
			
			return new ErrorResult("E posta adresi e posta formatına uygun değildir");
		}
		
		employerDao.save(employer);
		return new SuccessResult("İş veren sisteme kayıt edildi. " +  " Kaydın tamamlanması için " +  employer.getEmail() + " adresine doğrulama maili gönderildi");
		
		
	}



}
