package org.softdevelop.demo.banking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_order")
public class PaymentOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name is required")
    private double amount;
    @NotEmpty(message = "Currency is required")
    private String currency;
    @NotEmpty(message = "State is required")
    private State state;
    @NotEmpty(message = "Payment Date is required")
    private String paymentDate;

    @ManyToOne
    @JoinColumn(name="branchoffice_id")
    private BranchOffice branchOffice;
}

enum State {
    PAYED, DECLINED, FAILED, CANCELED
}
