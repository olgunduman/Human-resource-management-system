package Kodlama.io.Hrms.core.validations;

import Kodlama.io.Hrms.entities.concretes.User;

public interface EmailSendService {
	
	public boolean emailSend(User user);

}
