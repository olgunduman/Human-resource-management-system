package Kodlama.io.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User {
	
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_site")
	private String webSite;
	@Column(name = "telefone_number")
	private String telefoneNumber;

	
	@OneToMany(mappedBy = "employer")
	 @JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;
	
}
