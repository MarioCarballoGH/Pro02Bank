package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.model.BranchOffice;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("branch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IBranchOfficeController {
    @GET
    Collection<BranchOffice> getAllBranchOffices();

    @Path("{id}")
    @GET
    Response getById(@PathParam("id") Integer id);

    @Path("/save/{id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    BranchOffice addBranchOffice(@Valid @RequestBody BranchOffice branchOffice, @PathParam("id") Integer id);

    @Path("/payments/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response getPaymentOrdersByCurrency(@PathParam("id") Integer id, @Valid @RequestBody String currency);
}
