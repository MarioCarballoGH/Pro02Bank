package org.softdevelop.demo.banking.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BankRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BankRepository bankRepository;

    // write test cases here

    @Test
    public void whenFindById_thenReturnBank() {
        // given
        Bank bank = new Bank();
        bank.setName("Bank 2");
        bank.setAddress("Your Address");
        bank.setRegistrydate("2021-01-23");
        entityManager.persist(bank);
        entityManager.flush();

        // when
        Optional<Bank> found = bankRepository.findById(bank.getId());

        // then
        assertThat(found.get().getId())
                .isEqualTo(bank.getId());
    }
}
