package org.softdevelop.demo.banking.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@Setter
@Accessors(chain=true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "branchOfficeList"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Address is required")
    private String address;
    @NotEmpty(message = "Registry Date is required")
    private String registrydate;

    @XmlTransient
    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BranchOffice> branchOfficeList;
}
