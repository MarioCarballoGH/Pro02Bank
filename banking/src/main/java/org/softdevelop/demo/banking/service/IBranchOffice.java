package org.softdevelop.demo.banking.service;

import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.model.PaymentOrder;

import java.util.List;
import java.util.Optional;

public interface IBranchOffice {
    List<BranchOffice> getAllBranchOffices();
    Optional<BranchOffice> findById(int id);
    Optional<BranchOffice> findByName(String name);
    BranchOffice save(BranchOffice std, int id);
    void deleteById(int id);
    List<PaymentOrder> getPaymentOrdersByCurrency(String currency, int id);
}
