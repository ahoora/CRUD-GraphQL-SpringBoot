package com.joegabonito.graphqlspringboot.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joegabonito.graphqlspringboot.entities.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
	
}
