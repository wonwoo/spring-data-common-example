package ml.wonwoo.springdatacommonexample.person;

import ml.wonwoo.springdatacommonexample.custom.CustomizedPersonRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long>, CustomizedPersonRepository {

    <T> List<T> findByName(String name, Class<T> clazz);
}
