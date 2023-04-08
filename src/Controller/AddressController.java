package Controller;

import Models.Address;
import Service.AddressService;

import java.util.ArrayList;

public class AddressController {
    private AddressService addressService;
    public AddressController() {
        addressService = new AddressService();
    }
    public boolean addAddress(String street, String city, String country) {
        street = capitalizeString(street);
        city = capitalizeString(city);
        country = capitalizeString(country);
        return addressService.addAddress(street, city, country);
    }

    public ArrayList<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    public boolean updateAddress(int id, Address address) {
        return addressService.updateAddress(id, address);
    }

    public boolean deleteAddress(int id) {
        return addressService.deleteAddress(id);
    }
    private String capitalizeString (String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
