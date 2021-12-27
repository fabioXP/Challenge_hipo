package com.challenge.demo.repo;

import com.challenge.demo.models.People;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeopleRepo {
    int insertperson(UUID id, People person);

    default int insertperson(People person) {
        UUID id = UUID.randomUUID();
        return insertperson(id,person);
    }

    List<People> selectAllPeople();

    Optional<People> selectPersonById(UUID id);
    int deletePeopleById(UUID id);

    int updatePersonById(UUID id, People people);
}
