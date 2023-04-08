package Controller;


import Models.*;
import Service.ContractService;
import java.util.ArrayList;
import java.util.Date;

public class ContractController {
    private final ContractService contractService;

    public ContractController() {
        contractService = new ContractService();
    }
    public boolean addContract(int customerID, int employeeID, int carID, String startDate, String endDate) {
        return contractService.addContract(customerID, employeeID, carID, startDate, endDate);
    }
    public Contract getContractById(int id) {
        return contractService.getContractById(id);
    }

    public boolean updateContract(int id, Contract contract) {
        return contractService.updateContract(id, contract);
    }

    public boolean deleteContract(int id) {
        return contractService.deleteContract(id);
    }
}