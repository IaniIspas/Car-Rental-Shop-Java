package Service;

import Models.Contract;
import Repository.ContractRepository;

public class ContractService {
    private ContractRepository contractRepository;

    public ContractService() {
        this.contractRepository = ContractRepository.getInstance();
    }

    public Contract getContractById(int id) throws Exception {
        return contractRepository.findById(id);
    }

    public void createContract(Contract contract) throws Exception {
        contractRepository.create(contract);
    }

    public void updateContract(Contract contract) throws Exception {
        contractRepository.update(contract);
    }

    public void deleteContract(int id) throws Exception {
        contractRepository.delete(id);
    }
}
