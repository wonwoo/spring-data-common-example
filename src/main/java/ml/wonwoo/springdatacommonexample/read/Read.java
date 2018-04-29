package ml.wonwoo.springdatacommonexample.read;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Read {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
}
