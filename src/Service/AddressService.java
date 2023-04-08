package Service;

import Models.Address;
import Repository.AddressRepository;

import java.util.ArrayList;

public class AddressService {
    private AddressRepository addressRepository;
    private static int reg_no;
    public AddressService() {
        this.addressRepository = new AddressRepository();
    }

    public boolean addAddress(String street, String city, String country) {
        Address address = new Address(street, city, country);
        address.setId(reg_no);
        return this.addressRepository.add(address);
    }
    public ArrayList<Address> getAllAddresses() {
        return this.addressRepository.getAllAddresses();
    }
    public boolean updateAddress(int id, Address address) {
        return addressRepository.update(id, address);
    }
    public boolean deleteAddress(int id) {
        return addressRepository.delete(id);
    }
}
