package Repository;

import Models.Address;
import Models.Car;

import java.util.ArrayList;

public class AddressRepository {
    private ArrayList<Address> addresses = new ArrayList<Address>();
    public boolean add(Address address) {
        try {
            addresses.add(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public Address get(int i) {
        return addresses.get(i);
    }
    public ArrayList<Address> getAllAddresses() {
        return addresses;
    }

    public boolean update(int i, Address address) {
        try {
            addresses.set(i, address);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean delete(int i) {
        try {
            addresses.remove(i);
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
