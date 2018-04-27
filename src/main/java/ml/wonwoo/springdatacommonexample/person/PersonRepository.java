package ml.wonwoo.springdatacommonexample.person;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {

    <T> List<T> findByName(String name, Class<T> clazz);

}
