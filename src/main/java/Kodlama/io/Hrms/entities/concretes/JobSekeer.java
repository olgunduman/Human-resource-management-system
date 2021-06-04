package Kodlama.io.Hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity

@Table(name = "job_sekeers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class JobSekeer extends User{

	
	
	 
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "national_identity")
	private String nationalIdentity;
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<CoverLetter> coverLetters;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<JobExperience> jobExperiences ;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<JobSeekerPicture> jobSeekerPictures;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<Language> languages;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<Link> links;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<SchoolInfo> schoolInfos;
	
	@OneToMany(mappedBy = "jobSekeer")
	@JsonIgnore
	private List<Skill> skills;
	
	
	
	

}
