package org.softdevelop.demo.banking.controller;

import org.softdevelop.demo.banking.model.PaymentOrder;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("payment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface IPaymentOrderController {
    @GET
    Collection<PaymentOrder> getAllPaymentOrders();

    @Path("{id}")
    @GET
    Response getById(@PathParam("id") Integer id);

    @Path("/save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    PaymentOrder addPaymentOrder(@Valid @RequestBody PaymentOrder paymentOrder);
}
