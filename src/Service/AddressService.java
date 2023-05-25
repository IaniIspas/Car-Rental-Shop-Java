package Service;

import Models.Address;
import Repository.AddressRepository;
import java.util.List;

public class AddressService {
    private AddressRepository addressRepository;

    public AddressService() {
        this.addressRepository = AddressRepository.getInstance();
    }
    public Address getAddressById(int id) throws Exception {
        return addressRepository.findById(id);
    }

    public List<Address> getAllAddresses() throws Exception {
        return addressRepository.findAll();
    }

    public void createAddress(Address address) throws Exception {
        addressRepository.create(address);
    }

    public void updateAddress(Address address) throws Exception {
        addressRepository.update(address);
    }

    public void deleteAddress(int id) throws Exception {
        addressRepository.delete(id);
    }
}
