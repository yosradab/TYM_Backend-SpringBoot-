package tn.tym.esprit.interfaces;

import java.util.List;

import java.util.Optional;

import tn.tym.esprit.entities.Specialist;



public interface ISpecialistService {

	Specialist addSpecialists(Specialist specialist);


	


	List<Specialist> getAllSpecialists();


	void deleteSpecialist(Long id);





	Optional<Specialist> getSpecialistById(Long id);





	Specialist updateSpecialist(Specialist specialist);














	

}
