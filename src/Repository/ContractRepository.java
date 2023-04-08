package Repository;

import Models.Contract;
import Models.Person;

import java.util.ArrayList;

public class ContractRepository {
    private ArrayList<Contract> contracts = new ArrayList<Contract>();
    public boolean add(Contract contract) {
        try {
            contracts.add(contract);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Contract get(int id) {
        for (Contract contract : contracts) {
            if(id == contract.getId())
                return contract;
        }
        return null;
    }
    public boolean update(int id, Contract contract) {
        try {
            int cnt = 0;
            for (Contract contract1 : contracts) {
                if(contract1.getId() == id) {
                    contracts.set(cnt, contract);
                }
                cnt ++;
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean delete(int id) {
        try {
            int cnt = 0;
            for (Contract contract1 : contracts) {
                if(contract1.getId() == id) {
                    contracts.remove(cnt);
                }
                cnt ++;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
