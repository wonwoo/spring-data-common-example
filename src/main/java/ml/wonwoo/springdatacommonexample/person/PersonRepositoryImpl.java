package ml.wonwoo.springdatacommonexample.person;

import ml.wonwoo.springdatacommonexample.custom.CustomizedPersonRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonRepositoryImpl implements CustomizedPersonRepository {

  private final JdbcTemplate jdbcTemplate;

  public PersonRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public Person selectPersonName(String name) {
    return jdbcTemplate.queryForObject("select * from person where name = ?",
        new BeanPropertyRowMapper<>(Person.class), name);
  }

  @Override
  public void insert(Long id, String name) {
    jdbcTemplate.update("insert into person (id, name) values (?,?)", id, name);
  }
}
