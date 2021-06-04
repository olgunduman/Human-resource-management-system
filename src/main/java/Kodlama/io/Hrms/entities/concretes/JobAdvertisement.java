package Kodlama.io.Hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto;





@Entity
@Data
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "number_of_open_position")
	private int numberOfOpenPosition;
	
	 @Temporal(TemporalType.DATE)
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	 @Temporal(TemporalType.DATE)
	@Column(name = "release_date" ,nullable=false)
	private Date releaseDate;
	
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	 
	private Employer employer;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id",nullable=false)
	private JobPosition jobPosition;
	
	
	
	
 
}
