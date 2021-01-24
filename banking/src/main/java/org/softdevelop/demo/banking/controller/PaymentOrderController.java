package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.exceptions.BankNotFoundException;
import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.service.impl.PaymentOrderService;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Collection;

public class PaymentOrderController implements IPaymentOrderController {

    private final PaymentOrderService service;

    public PaymentOrderController(PaymentOrderService service) {
        this.service = service;
    }

    @Override
    public Collection<PaymentOrder> getAllPaymentOrders() {
        return service.getAllPaymentOrders();
    }

    @Override
    public Response getById(Integer id) {
        PaymentOrder paymentOrder = service.findById(id).orElseThrow(BankNotFoundException::new);
        return Response.ok(paymentOrder).build();
    }

    @Override
    public PaymentOrder addPaymentOrder(@Valid PaymentOrder paymentOrder) {
        return service.save(paymentOrder);
    }
}
