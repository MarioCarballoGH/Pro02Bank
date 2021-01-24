package org.softdevelop.demo.banking.service.impl;

import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.repository.PaymentOrderRepository;
import org.softdevelop.demo.banking.service.IPaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentOrderService implements IPaymentOrder {
    private PaymentOrderRepository paymentOrderRepository;
    @Autowired
    public PaymentOrderService(PaymentOrderRepository paymentOrderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
    }
    @Override
    public List<PaymentOrder> getAllPaymentOrders() {
        return paymentOrderRepository.findAll();
    }

    @Override
    public Optional<PaymentOrder> findById(int id) {
        return paymentOrderRepository.findById(id);
    }

    @Override
    public PaymentOrder save(PaymentOrder std) {
        return paymentOrderRepository.save(std);
    }

    @Override
    public void deleteById(int id) {
        paymentOrderRepository.deleteById(id);
    }
}
