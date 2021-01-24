package org.softdevelop.demo.banking.dto;

import org.softdevelop.demo.banking.model.BranchOffice;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "BranchOfficeResponse")
public class BranchOfficeResponse {
    private List<BranchOffice> branchOfficeList;

    public List<BranchOffice> getBranchOfficeList() {
        return branchOfficeList;
    }

    public void setBranchOfficeList(List<BranchOffice> branchOfficeList) {
        this.branchOfficeList = branchOfficeList;
    }
}
