package ml.wonwoo.springdatacommonexample.read;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface ReadRepository<T, ID> extends Repository<T, ID>{

  <S extends T> Iterable<S> saveAll(Iterable<S> var1);

  Optional<T> findById(ID var1);

  boolean existsById(ID var1);

  Iterable<T> findAll();

  Iterable<T> findAllById(Iterable<ID> var1);

  long count();

}
