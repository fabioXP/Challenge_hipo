package com.challenge.demo.controllers;

import java.util.List;
import java.util.UUID;

import com.challenge.demo.models.People;
import com.challenge.demo.services.Peopleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class PeopleController {

    private Peopleservice peopleservice;

    @Autowired
    public PeopleController(Peopleservice peopleservice) {
        this.peopleservice = peopleservice;
    }

    @PostMapping(path = "newperson")
    public void NewPeople(@RequestBody People person){
        peopleservice.NewPeople(person);
    }

   @RequestMapping("/people")
    public List<People> getAllPeople() {
        return peopleservice.getAllPeople();
    }

    @RequestMapping(path="/people-{id}")
    public People getPersonByID(@PathVariable("id") UUID id) {
        return peopleservice.getPersonByid(id).
                orElse(null);
    }
    @DeleteMapping(path="/delete/people-{id}")
    public void deletePersonById(@PathVariable("id")UUID id){
        peopleservice.deletePerson(id);
    }

    @PutMapping(path = "/update/person-{id}")
    public void updatePerson(@PathVariable("id") UUID id,@RequestBody People personToUpdate){
        peopleservice.updatePersonById(id, personToUpdate);
    }

}