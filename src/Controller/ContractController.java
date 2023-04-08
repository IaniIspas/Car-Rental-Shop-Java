package Controller;


import Models.Car;
import Models.Contract;
import Models.Customer;
import Models.Employee;
import Service.ContractService;
import java.util.ArrayList;
import java.util.Date;

public class ContractController {
    private final ContractService contractService;

    public ContractController() {
        contractService = new ContractService();
    }
    public boolean addContract(Customer customer, Employee employee, Car car, Date startDate, Date endDate) {
        return contractService.addContract(customer, employee, car, startDate, endDate);
    }
    public Contract getContractById(int id) {
        return contractService.getContractById(id);
    }

    public ArrayList<Contract> getAllContracts() {
        return contractService.getAllContracts();
    }

    public boolean updateContract(int id, Contract contract) {
        return contractService.updateContract(id, contract);
    }

    public boolean deleteContract(int id) {
        return contractService.deleteContract(id);
    }
}