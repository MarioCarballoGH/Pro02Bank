package org.softdevelop.demo.banking.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BranchOfficeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BranchOfficeRepository branchOfficeRepository;

    // write test cases here

    @Test
    public void whenFindById_thenReturnBank() {
        // given
        BranchOffice branch = new BranchOffice();
        branch.setName("Bank 2");
        branch.setAddress("Your Address");
        branch.setRegistrydate("2021-01-23");
        entityManager.persist(branch);
        entityManager.flush();

        // when
        Optional<BranchOffice> found = branchOfficeRepository.findById(branch.getId());

        // then
        assertThat(found.get().getId())
                .isEqualTo(branch.getId());
    }
}