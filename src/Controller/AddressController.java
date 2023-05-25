package Controller;

import Models.Address;
import Service.AddressService;

import java.util.List;

public class AddressController {
    private AddressService addressService;
    public AddressController() {
        this.addressService = new AddressService();
    }
    public Address getAddressById(int id) throws Exception {
        return addressService.getAddressById(id);
    }
    public List<Address> getAllAddresses() throws Exception {
        return addressService.getAllAddresses();
    }
    public void createAddress(Address address) throws Exception {
        addressService.createAddress(address);
    }
    public void updateAddress(Address address) throws Exception {
        addressService.updateAddress(address);
    }
    public void deleteAddress(int id) throws Exception {
        addressService.deleteAddress(id);
    }
}
