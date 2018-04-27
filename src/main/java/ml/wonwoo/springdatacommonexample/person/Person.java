package ml.wonwoo.springdatacommonexample.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    Person() {

    }
    public Person(String name) {
        this.name = name;
    }

}
