package org.softdevelop.demo.banking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.model.BranchOffice;
import org.softdevelop.demo.banking.service.IBranchOffice;
import org.softdevelop.demo.banking.service.impl.BankService;
import org.softdevelop.demo.banking.service.impl.BranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(BranchOfficeController.class)
public class BranchOfficeControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BranchOfficeService service;

    @MockBean
    private IBranchOfficeController branchOffice;

    // write test cases here
    @Test
    public void givenBanks_whenGetBanks_thenReturnJsonArray()
            throws Exception {

        BranchOffice branchOffice = new BranchOffice();
        branchOffice.setName("Branch 2");
        branchOffice.setAddress("Your Address");
        branchOffice.setRegistrydate("2021-01-23");

        List<BranchOffice> allBranch = Arrays.asList(branchOffice);

//        when(bankController.getAllBanks()).thenReturn(allBanks);
//        when(service.getAllBanks()).thenReturn(allBanks);
        given(service.getAllBranchOffices()).willReturn(allBranch);

        mvc.perform(get("/bankservices/branch")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(branchOffice.getName())));
    }
}
