package Kodlama.io.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
