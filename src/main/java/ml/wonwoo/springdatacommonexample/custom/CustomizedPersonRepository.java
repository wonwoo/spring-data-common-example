package ml.wonwoo.springdatacommonexample.custom;

import ml.wonwoo.springdatacommonexample.person.Person;

public interface CustomizedPersonRepository {

  Person selectPersonName(String name);

  void insert(Long id, String name);
}
