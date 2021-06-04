package Kodlama.io.Hrms.core.validations;

import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.entities.concretes.JobSekeer;

@Service
public class FakeMernisManager implements FakeMernisService {

	@Override
	public boolean fakeMernisSend(JobSekeer jobSekeer) {
		
		if(jobSekeer.getNationalIdentity().length()>10 ) {
			System.out.println("Fake mernis doğrulama başarılı");
			return true;
		
			
		}
		else {
			System.out.println("fake mernis hata");
			return false;
		}
		
		
		
		
	}

}
