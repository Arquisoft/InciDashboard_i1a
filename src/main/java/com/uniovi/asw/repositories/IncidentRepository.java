package com.uniovi.asw.repositories;

import java.util.List;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import org.springframework.data.jpa.repository.Query;
>>>>>>> Pedro
import org.springframework.data.repository.CrudRepository;

import com.uniovi.asw.entities.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long> {
	public List<Incident> findAll();
	public List<Incident> findByTopic(String topic);
<<<<<<< HEAD
	public Page<Incident> findAll(Pageable pageable);
=======
	
	@Query("SELECT i FROM Incident i WHERE i.id = ?1")
	public Incident findById(Long id);
>>>>>>> Pedro
}
