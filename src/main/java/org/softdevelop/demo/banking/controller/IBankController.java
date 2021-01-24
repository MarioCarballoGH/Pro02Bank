package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.model.Bank;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("bank")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IBankController {

    @GET
    Collection<Bank> getAllBanks();

    @Path("{id}")
    @GET
    Response getById(@PathParam("id") Integer id);

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Bank addBank(@Valid @RequestBody Bank bank);

}
