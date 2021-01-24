package org.softdevelop.demo.banking.repository;

import org.softdevelop.demo.banking.model.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Integer> {
    Optional<BranchOffice> findByName(String name);
}
