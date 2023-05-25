package Controller;

import Models.Contract;
import Service.ContractService;

import java.util.List;

public class ContractController {
    private final ContractService contractService;

    public ContractController() {
        this.contractService = new ContractService();
    }

    public Contract getContractById(int id) throws Exception {
        return contractService.getContractById(id);
    }

    public void createContract(Contract contract) throws Exception {
        contractService.createContract(contract);
    }

    public void updateContract(Contract contract) throws Exception {
        contractService.updateContract(contract);
    }

    public void deleteContract(int id) throws Exception {
        contractService.deleteContract(id);
    }
}
