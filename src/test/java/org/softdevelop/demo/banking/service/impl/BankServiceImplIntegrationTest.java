package org.softdevelop.demo.banking.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.softdevelop.demo.banking.service.IBank;
import org.softdevelop.demo.banking.service.impl.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BankServiceImplIntegrationTest {
    @TestConfiguration
    static class BankServiceImplIntegrationTestContextConfiguration {

        @Bean
        public IBank bankService() {
            return new BankService();
        }
    }

    @Autowired
    private IBank bankService;

    @MockBean
    private BankRepository bankRepository;

    @Before
    public void setUp() {
        Bank bank = new Bank();
        bank.setName("Bank 2");
        bank.setAddress("Your Address");
        bank.setRegistrydate("2021-01-23");

        Mockito.when(bankRepository.findByName(bank.getName()))
                .thenReturn(Optional.of(bank));
    }

    // write test cases here
    @Test
    public void whenValidName_thenBankShouldBeFound() {
        String name = "Bank 2";
        Optional<Bank> found = bankRepository.findByName(name);

        assertThat(found.get().getName())
                .isEqualTo(name);
    }
}
