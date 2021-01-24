package org.softdevelop.demo.banking.ws;

import org.softdevelop.demo.banking.dto.BranchOfficeRequest;
import org.softdevelop.demo.banking.dto.BranchOfficeResponse;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.service.impl.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BranchesWSImpl implements IBranchesWS {
    private static final Logger LOG = Logger.getLogger(BranchesWSImpl.class.getName());

    @Autowired
    private BankService bankService;

    @Override
    public BranchOfficeResponse getBranchOfficebyBankName(BranchOfficeRequest branchRequest) {
        Optional<Bank> bank = bankService.findByName(branchRequest.getBankName());
        List<BranchOffice> result = bankService.getBranchOfficesByBankId(bank.get().getId());
        BranchOfficeResponse branchOfficeResponse = new BranchOfficeResponse();
        branchOfficeResponse.setBranchOfficeList(result);
        return branchOfficeResponse;
    }
}
