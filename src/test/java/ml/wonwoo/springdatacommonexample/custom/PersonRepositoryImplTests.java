package ml.wonwoo.springdatacommonexample.custom;

import ml.wonwoo.springdatacommonexample.person.Person;
import ml.wonwoo.springdatacommonexample.person.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryImplTests {


  @Autowired
  private PersonRepository personRepository;

  @Test
  public void custom() {
    personRepository.insert(1L,"wonwoo");
    Person person = personRepository.selectPersonName("wonwoo");
    assertThat(person.getName()).isEqualTo("wonwoo");
  }
}