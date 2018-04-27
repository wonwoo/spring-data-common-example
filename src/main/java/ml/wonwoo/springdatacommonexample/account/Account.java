package ml.wonwoo.springdatacommonexample.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    Account() {

    }
    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
