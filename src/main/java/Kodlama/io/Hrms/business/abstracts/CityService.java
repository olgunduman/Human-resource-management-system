package Kodlama.io.Hrms.business.abstracts;

import java.util.List;

import Kodlama.io.Hrms.core.utilities.results.DataResult;
import Kodlama.io.Hrms.entities.concretes.City;

public interface CityService {

	
	DataResult<List<City>> getAll();
}
