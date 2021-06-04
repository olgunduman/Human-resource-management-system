package Kodlama.io.Hrms.core.validations;


import org.springframework.stereotype.Service;


import Kodlama.io.Hrms.entities.concretes.JobSekeer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisValidationManager implements MernisValidationService{

	@Override
	public boolean checkIfRealPerson(JobSekeer jobSekeer) {

			KPSPublicSoap soapClient = new KPSPublicSoapProxy();

		boolean result = false;

		try {

			result = soapClient.TCKimlikNoDogrula(Long.parseLong(jobSekeer.getNationalIdentity()), jobSekeer.getFirstName(),
					jobSekeer.getLastName(), jobSekeer.getDateOfBirth().getYear());
		if (result) {
			System.out.println("mernis doğrulaması başarılı");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Kimlik doğrulanamadı");
		//return new SuccessResult();
		return result;
	}
}
