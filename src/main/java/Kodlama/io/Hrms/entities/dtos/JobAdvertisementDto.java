package Kodlama.io.Hrms.entities.dtos;


import java.util.Date;


import Kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {


	private String companyName;
	private String PositionName;
	private int numberOfOpenPosition;
	private Date releaseDate;
	private Date applicationDeadline;
	
	
	
}
