package Kodlama.io.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Kodlama.io.Hrms.entities.concretes.Employer;
import Kodlama.io.Hrms.entities.concretes.JobAdvertisement;
import Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("Select new Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, jp.positionName, j.numberOfOpenPosition, j.releaseDate, j.applicationDeadline)"
			+ "From JobAdvertisement j Inner Join j.jobPosition jp Inner Join j.employer e  where j.isActive=true")
	List<JobAdvertisementDto> findByIsActiveTrue();

	@Query("Select new Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, jp.positionName, j.numberOfOpenPosition, j.releaseDate, j.applicationDeadline)"
			+ "From JobAdvertisement j Inner Join j.jobPosition jp Inner Join j.employer e  where j.isActive=true Order By j.releaseDate ASC")
	List<JobAdvertisementDto> findByIsActiveOrderByReleaseDate();

	@Query("Select new Kodlama.io.Hrms.entities.dtos.JobAdvertisementDto"
			+ "(e.companyName, jp.positionName, j.numberOfOpenPosition, j.releaseDate, j.applicationDeadline)"
			+ "From JobAdvertisement j  Inner Join j.jobPosition jp  Inner Join j.employer e where  j.isActive=true And e.companyName=:companyName  ")
	List<JobAdvertisementDto> findByEmployer_CompanyName(String companyName);

}

// select * from products
// select p.id,p.name from products p
