package com.challenge.demo.repo;

import com.challenge.demo.models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("PersonDAS")
public class PersonDataAccesService implements PeopleRepo{
    private final JdbcTemplate jdbcTemplate;

    private static List<People> DB= new ArrayList<>();

    @Autowired
    public PersonDataAccesService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertperson(UUID id, People person) {
        String sql ="INSERT INTO person(id,name,age,gender) VALUES(uuid_generate_v4()"+",'"+person.getName()+"',"+person.getAge()+",'"+person.getGender()+"')";
        jdbcTemplate.update(sql);
        return 1;
    }

    @Override
    public List<People> selectAllPeople() {
        String sql="SELECT * FROM person";
        List<People> people =jdbcTemplate.query(sql,(resultSet,i)->{
            UUID id=UUID.fromString(resultSet.getString("id"));
            return  new People(
                    id,
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("gender")
            );
        });
        return people;
    }

    @Override
    public Optional<People> selectPersonById(UUID id) {
        final String sql = "SELECT * FROM person WHERE id=?";
        People people =jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet,i)->{
            UUID personId=UUID.fromString(resultSet.getString("id"));
            return  new People(
                    personId,
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getString("gender")
            );
        });
        return Optional.ofNullable(people);
    }

    @Override
    public int deletePeopleById(UUID id) {
        final String sql = "DELETE FROM person WHERE id=?";
        Object[] person= new Object[]{id};
        jdbcTemplate.update(sql,person);
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, People newpeople) {
        final String sql = "UPDATE person SET name=?, age=?, gender=?  WHERE id=?";
        Optional<People> oldperson=selectPersonById(id);
        People person=oldperson.get();
        if (newpeople.getName()==null){
            newpeople.setName(person.getName());
        }
        if (newpeople.getAge()==0){
            newpeople.setAge(person.getAge());
        }
        if (newpeople.getGender()==null){
            newpeople.setGender(person.getGender());
        }
        jdbcTemplate.update(sql,
                    newpeople.getName(),newpeople.getAge(),newpeople.getGender(),id);
        return 1;
    }


}
