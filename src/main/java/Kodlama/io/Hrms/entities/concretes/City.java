package Kodlama.io.Hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class City {
	
	
	@Id
	@Column(name = "city_id")
	private int id;
	@Column(name = "city_name")
	private String cityName;
	
	
	@OneToMany(mappedBy = "city")
	 @JsonIgnore
	private List<JobAdvertisement> jobAdvertisements;
	

	

}
 