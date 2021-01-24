package org.softdevelop.demo.banking.service.impl;

import lombok.NoArgsConstructor;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.softdevelop.demo.banking.service.IBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class BankService implements IBank {
    private BankRepository bankRepository;
    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    @Override
    public List<Bank> getAllBanks() {
        // TODO Auto-generated method stub
        return bankRepository.findAll();
    }
    @Override
    public Optional<Bank> findById(int id) {
        // TODO Auto-generated method stub
        return bankRepository.findById(id);
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public Bank save(Bank std) {
        // TODO Auto-generated method stub
        return bankRepository.save(std);
    }
    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        bankRepository.deleteById(id);
    }

    @Override
    public List<BranchOffice> getBranchOfficesByBankId(int id) {
        Optional<Bank> bank = bankRepository.findById(id);
        List<BranchOffice> branchOffices = new ArrayList<>();
        if(bank.isPresent()){
            branchOffices = bank.get().getBranchOfficeList();
        }
        return branchOffices;
    }
}
