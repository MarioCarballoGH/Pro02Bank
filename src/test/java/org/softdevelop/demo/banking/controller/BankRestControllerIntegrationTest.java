package org.softdevelop.demo.banking.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.softdevelop.demo.banking.controller.BankController;
import org.softdevelop.demo.banking.controller.IBankController;
import org.softdevelop.demo.banking.model.Bank;
import org.softdevelop.demo.banking.service.IBank;
import org.softdevelop.demo.banking.service.impl.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(BankController.class)
public class BankRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BankService service;

    @MockBean
    private IBankController bankController;

    // write test cases here
    @Test
    public void givenBanks_whenGetBanks_thenReturnJsonArray()
            throws Exception {

        Bank bank = new Bank();
        bank.setName("Bank 2");
        bank.setAddress("Your Address");
        bank.setRegistrydate("2021-01-23");

        List<Bank> allBanks = Arrays.asList(bank);

//        when(bankController.getAllBanks()).thenReturn(allBanks);
//        when(service.getAllBanks()).thenReturn(allBanks);
        given(service.getAllBanks()).willReturn(allBanks);

        mvc.perform(get("/bankservices/bank")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(bank.getName())));
    }
}
