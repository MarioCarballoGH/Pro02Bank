package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.exceptions.BankNotFoundException;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.model.PaymentOrder;
import org.softdevelop.demo.banking.service.impl.BranchOfficeService;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

public class BranchOfficeController implements IBranchOfficeController {

    private final BranchOfficeService service;

    public BranchOfficeController(BranchOfficeService service) {
        this.service = service;
    }

    @Override
    public Collection<BranchOffice> getAllBranchOffices() {
        return service.getAllBranchOffices();
    }

    @Override
    public Response getById(Integer id) {
        BranchOffice branchOffice = service.findById(id).orElseThrow(BankNotFoundException::new);
        return Response.ok(branchOffice).build();
    }

    @Override
    public BranchOffice addBranchOffice(@Valid BranchOffice branchOffice, Integer id) {
        return service.save(branchOffice, id);
    }

    @Override
    public Response getPaymentOrdersByCurrency(Integer id, @Valid String currency) {
        List<PaymentOrder> paymentOrders = service.getPaymentOrdersByCurrency(currency, id);
        return Response.ok(paymentOrders).build();
    }
}
