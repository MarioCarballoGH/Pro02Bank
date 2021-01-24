package org.softdevelop.demo.banking.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.repository.BranchOfficeRepository;
import org.softdevelop.demo.banking.service.IBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class BranchOfficeServiceIntegrationTest {

    @TestConfiguration
    static class BankServiceImplIntegrationTestContextConfiguration {

        @Bean
        public IBranchOffice branchService() {
            return new BranchOfficeService();
        }
    }

    @Autowired
    private IBranchOffice branchService;

    @MockBean
    private BranchOfficeRepository branchOfficeRepository;

    @Before
    public void setUp() {
        BranchOffice branch = new BranchOffice();
        branch.setName("Office 2");
        branch.setAddress("Your Address");
        branch.setRegistrydate("2021-01-23");

        Mockito.when(branchOfficeRepository.findByName(branch.getName()))
                .thenReturn(Optional.of(branch));
    }

    // write test cases here
    @Test
    public void whenValidName_thenBankShouldBeFound() {
        String name = "Office 2";
        Optional<BranchOffice> found = branchOfficeRepository.findByName(name);

        assertThat(found.get().getName())
                .isEqualTo(name);
    }
}