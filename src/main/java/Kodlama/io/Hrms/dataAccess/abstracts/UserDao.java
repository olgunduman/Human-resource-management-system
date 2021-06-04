package Kodlama.io.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
	/*
	email kontrolü buradan kullanıldı. çünkü bir kişi şirket maili ile iş arayan kısmına kayıt olabilir. 
	aynı mail ile iş veren olarak da kayıt olmak isteyebilir. eğer biz employeruserdao ve jobseekerdao ya ayrı ayrı findbyemail eklersek 
	bu kontrolden yukarıda anlattığım işlemi yapan kişi geçebilir. 
	Bu sebeple findByEmail buraya eklendi
	*/

}
