package org.softdevelop.demo.banking.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BranchOfficeRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchOfficeRequest {

    @XmlElement(required = true)
    String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
