package org.softdevelop.demo.banking.service;

import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;

import java.util.List;
import java.util.Optional;

public interface IBank {
    List<Bank> getAllBanks();
    Optional<Bank> findById(int id);
    Optional<Bank> findByName(String email);
    Bank save(Bank std);
    void deleteById(int id);
    List<BranchOffice> getBranchOfficesByBankId(int id);
}
