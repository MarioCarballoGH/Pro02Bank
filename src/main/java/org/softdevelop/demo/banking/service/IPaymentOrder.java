package org.softdevelop.demo.banking.service;

import org.softdevelop.demo.banking.model.PaymentOrder;

import java.util.List;
import java.util.Optional;

public interface IPaymentOrder {
    List<PaymentOrder> getAllPaymentOrders();
    Optional<PaymentOrder> findById(int id);
    PaymentOrder save(PaymentOrder std);
    void deleteById(int id);
    PaymentOrder assignOrderToBranch(int orderId, int branchId);

}
