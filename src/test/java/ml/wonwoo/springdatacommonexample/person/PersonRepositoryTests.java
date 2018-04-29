package ml.wonwoo.springdatacommonexample.person;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ml.wonwoo.springdatacommonexample.person.projections.Named;
import ml.wonwoo.springdatacommonexample.person.projections.PersonDto;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTests {
    
    @Autowired
    private PersonRepository personRepository;
    
    @Test
    public void personsTest() {
        personRepository.save(new Person("wonwoo"));
        Iterable<Person> persons = personRepository.findAll();
        assertThat(persons.iterator().next().getName()).isEqualTo("wonwoo");
    }

    @Test
    public void personsClassDynamicProjectionsTest() {
        personRepository.save(new Person("wonwoo"));
        personRepository.save(new Person("wonwoo"));
        List<PersonDto> persons = personRepository.findByName("wonwoo", PersonDto.class);
        assertThat(persons).hasSize(2);
    }

    @Test
    public void personsInterfaceProjectionsTest() {
        personRepository.save(new Person("wonwoo"));
        personRepository.save(new Person("wonwoo"));
        List<PersonDto> persons = personRepository.findByName("wonwoo");
//        List<Named> persons = personRepository.findByName("wonwoo");
        assertThat(persons).hasSize(2);
        assertThat(persons.iterator().next().getName()).isEqualTo("wonwoo");
    }

    @Test
    public void personsInterfaceDynamicProjectionsTest() {
        personRepository.save(new Person("wonwoo"));
        personRepository.save(new Person("wonwoo"));
        List<Named> persons = personRepository.findByName("wonwoo", Named.class);
        assertThat(persons.get(0).getName()).isEqualTo("wonwoo");
        assertThat(persons.get(1).getName()).isEqualTo("wonwoo");
    }
}