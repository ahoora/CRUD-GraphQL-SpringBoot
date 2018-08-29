package com.joegabonito.graphqlspringboot.mutations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.joegabonito.graphqlspringboot.entities.Pet;
import com.joegabonito.graphqlspringboot.enums.Animal;
import com.joegabonito.graphqlspringboot.repositories.PetRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
	@Autowired
	private PetRepository PetRepository;
	
	public Mutation(PetRepository PetRepository){
		this.PetRepository = PetRepository;
	}
	//Can Create, Update, Delete with one method!!!
	public Pet cudPet(long id, String name, int age, Animal type, String delete_yn) {
		Pet pet = new Pet();
		pet.setId(id);
		pet.setName(name);
		pet.setAge(age);
		pet.setType(type);
		pet.setDelete_yn(delete_yn);
        return PetRepository.save(pet);
    }
}
