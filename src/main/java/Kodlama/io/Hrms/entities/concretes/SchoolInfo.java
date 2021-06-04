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
@Table(name = "school_infos")
public class SchoolInfo {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@NotNull
	@Column(name = "school_name")
	private String schoolName;
	
	@NotBlank
	@NotNull
	@Column(name = "department")
	private String department;
	
	@NotBlank
	@NotNull
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "graduation_year")
	private LocalDate graduationYear;
	
	
	@ManyToOne()
	@JoinColumn(name = "user_id" ,nullable = false)
	private JobSekeer jobSekeer;
}
