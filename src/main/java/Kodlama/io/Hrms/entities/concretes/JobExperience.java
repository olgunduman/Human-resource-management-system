package Kodlama.io.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")

public class JobExperience {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotBlank
	@NotNull
	@Column(name = "position_name")
	private String positionName;
	
	@NotBlank
	@NotNull
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "leaving_work_date")
	private LocalDate leavingWorkDate;
	
	@ManyToOne()
	@JoinColumn(name = "user_id" , nullable = false)
	private JobSekeer jobSekeer;
	
}
