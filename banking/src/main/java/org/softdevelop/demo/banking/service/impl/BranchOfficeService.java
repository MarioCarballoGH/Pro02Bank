package org.softdevelop.demo.banking.service.impl;

import lombok.NoArgsConstructor;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.repository.BankRepository;
import org.softdevelop.demo.banking.repository.BranchOfficeRepository;
import org.softdevelop.demo.banking.service.IBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class BranchOfficeService implements IBranchOffice {
    private BranchOfficeRepository branchOfficeRepository;
    private BankRepository bankRepo;
    @Autowired
    public BranchOfficeService(BranchOfficeRepository branchOfficeRepository, BankRepository bankRepo) {
        this.branchOfficeRepository = branchOfficeRepository;
        this.bankRepo = bankRepo;
    }
    @Override
    public List<BranchOffice> getAllBranchOffices() {
        return branchOfficeRepository.findAll();
    }

    @Override
    public Optional<BranchOffice> findById(int id) {
        return branchOfficeRepository.findById(id);
    }

    @Override
    public Optional<BranchOffice> findByName(String name) {
        return branchOfficeRepository.findByName(name);
    }

    @Override
    public BranchOffice save(BranchOffice std, int id) {
        Optional<Bank> bank = bankRepo.findById(id);
        bank.ifPresent(std::setBank);
        return branchOfficeRepository.save(std);
    }

    @Override
    public void deleteById(int id) {
        branchOfficeRepository.deleteById(id);
    }

    @Override
    public List<PaymentOrder> getPaymentOrdersByCurrency(String currency, int id) {
        Optional<BranchOffice> branchOffice = branchOfficeRepository.findById(id);
        List<PaymentOrder> paymentOrders = new ArrayList<>();
        if(branchOffice.isPresent()){
            paymentOrders = branchOffice.get()
                    .getPaymentOrderList()
                    .stream()
                    .filter(paymentOrder -> paymentOrder.getCurrency().equals(currency)).collect(Collectors.toList());
        }
        return paymentOrders;
    }
}
