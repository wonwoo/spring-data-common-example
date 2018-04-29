package ml.wonwoo.springdatacommonexample.read;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ReadValueRepositoryTests {


  @Autowired
  private ReadValueRepository readValueRepository;

  @Test
  public void readTest() {
    Iterable<Read> reads = readValueRepository.findAll();
    assertThat(reads).hasSize(0);
  }
}