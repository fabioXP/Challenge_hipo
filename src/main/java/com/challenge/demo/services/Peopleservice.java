package com.challenge.demo.services;

import com.challenge.demo.models.People;
import com.challenge.demo.repo.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Peopleservice {

    private PeopleRepo peopleRepo;

    @Autowired
    public Peopleservice(@Qualifier("PersonDAS") PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public int NewPeople(People person){
        return peopleRepo.insertperson(person);
    }

    public List<People> getAllPeople(){
        return peopleRepo.selectAllPeople();
    }


    public Optional<People> getPersonByid(UUID id){
        return peopleRepo.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return peopleRepo.deletePeopleById(id);
    }

    public int updatePersonById(UUID id, People newPerson){
        return peopleRepo.updatePersonById(id, newPerson);
    }
}
