package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.exceptions.BankNotFoundException;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.service.impl.BankService;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Collection;

public class BankController implements IBankController {

    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @Override
    public Collection<Bank> getAllBanks() {
        return service.getAllBanks();
    }

    @Override
    public Response getById(Integer id) {
        Bank bank = service.findById(id).orElseThrow(BankNotFoundException::new);
        return Response.ok(bank).build();
    }

    @Override
    public Bank addBank(@Valid Bank bank) {
        return service.save(bank);
    }

}
