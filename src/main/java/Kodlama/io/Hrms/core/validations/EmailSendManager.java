package Kodlama.io.Hrms.core.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import Kodlama.io.Hrms.entities.concretes.User;

@Service
public class EmailSendManager implements EmailSendService {

	@Override
	public boolean emailSend(User user) {
		// doğrulama maili gönderildi
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean matchFound = matcher.find();
		if(!matchFound) {
			// e posta formatında olmalı
			return false;
		}
		return true;
	}

}
