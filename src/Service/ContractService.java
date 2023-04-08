package Service;
import Models.Car;
import Models.Contract;
import Models.Customer;
import Models.Employee;
import Repository.ContractRepository;
import java.util.ArrayList;
import java.util.Date;

public class ContractService {
    private ContractRepository contractRepository;
    private static int reg_no;

    public ContractService() {
        this.contractRepository = new ContractRepository();
        reg_no++;
    }

    public boolean addContract(Customer customer, Employee employee, Car car, Date startDate, Date endDate) {
        Contract contract = new Contract(customer, employee, car, startDate, endDate);
        contract.setId(reg_no);
        return contractRepository.add(contract);
    }

    public Contract getContractById(int id) {
        return contractRepository.get(id);
    }

    public ArrayList<Contract> getAllContracts() {
        return contractRepository.getAllContracts();
    }

    public boolean updateContract(int id, Contract contract) {
        return contractRepository.update(id, contract);
    }

    public boolean deleteContract(int id) {
        return contractRepository.delete(id);
    }
}