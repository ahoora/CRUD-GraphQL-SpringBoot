package com.joegabonito.graphqlspringboot.resolvers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.joegabonito.graphqlspringboot.entities.Pet;
import com.joegabonito.graphqlspringboot.repositories.PetRepository;

@Component
public class Query implements GraphQLQueryResolver {
	@Autowired
	private final PetRepository PetRepository;
	
	public Query(PetRepository petrepository) {
		this.PetRepository = petrepository;
	}
	
	//Returns only the ones that are not deleted.
    public Iterable<Pet> getPets() {
        Iterable<Pet> pets = PetRepository.findAll();
        Iterator itr = pets.iterator();

        while(itr.hasNext()) {
        	Object pet = itr.next();
        	if(((Pet) pet).getDelete_yn().equals("Y")) {
        		itr.remove();
        	}
        	itr.next();
        }
    	return pets;
    }
    
    //Returns only the one that is not deleted.
    public Optional<Pet> getPet(long id) {
    	Optional<Pet> pet = PetRepository.findById(id);
    	if(pet.get().getDelete_yn().equals("N")) 
    		return pet;
    	else 
    		return null;
    }
}
