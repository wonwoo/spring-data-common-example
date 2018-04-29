package ml.wonwoo.springdatacommonexample.person;

import ml.wonwoo.springdatacommonexample.custom.CustomizedPersonRepository;
import ml.wonwoo.springdatacommonexample.person.projections.Named;
import ml.wonwoo.springdatacommonexample.person.projections.PersonDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>, CustomizedPersonRepository {

    <T> List<T> findByName(String name, Class<T> clazz);

    List<PersonDto> findByName(String name);

}
