package ml.wonwoo.springdatacommonexample.account;


import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ml.wonwoo.springdatacommonexample.account.projections.AccountDto;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {


    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void save() {
        Account account = accountRepository.save(new Account("wonwoo", "test@test.com"));
        assertThat(account.getName()).isEqualTo("wonwoo");
        assertThat(account.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void findById() {
        Account account = accountRepository.save(new Account("wonwoo", "test@test.com"));
        Optional<Account> newAccount = accountRepository.findById(account.getId());
        assertThat(newAccount.get().getName()).isEqualTo("wonwoo");
        assertThat(newAccount.get().getEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void findAll() {
        accountRepository.save(new Account("wonwoo", "test@test.com"));
        accountRepository.save(new Account("kevin", "kevin@test.com"));
        List<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(2);
    }

    @Test
    public void findByName() {
        accountRepository.save(new Account("wonwoo", "test@test.com"));
        accountRepository.save(new Account("wonwoo", "kevin@test.com"));
        List<AccountDto> accounts = accountRepository.findByName("wonwoo", AccountDto.class);
        assertThat(accounts).hasSize(2);
    }


}