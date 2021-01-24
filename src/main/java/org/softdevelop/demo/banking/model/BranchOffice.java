package org.softdevelop.demo.banking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch_office")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "paymentOrderList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchOffice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Address is required")
    private String address;
    @NotEmpty(message = "Registry Date is required")
    private String registrydate;

    @ManyToOne()
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy="branchOffice", fetch = FetchType.EAGER)
    private List<PaymentOrder> paymentOrderList;
}
