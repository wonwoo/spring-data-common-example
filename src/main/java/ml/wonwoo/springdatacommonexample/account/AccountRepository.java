package ml.wonwoo.springdatacommonexample.account;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(idClass = Long.class, domainClass = Account.class)
public interface AccountRepository {

    List<Account> findAll();

    Optional<Account> findById(Long id);

    Account save(Account account);

    <T> List<T> findByName(String name, Class<T> clazz);
}
