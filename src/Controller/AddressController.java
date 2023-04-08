package Controller;

import Models.Address;
import Models.Person;
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

    public void displayAllPersons() {
        ArrayList<Address> addresses = addressService.getAllAddresses();
        if (addresses.isEmpty()) {
            System.out.println("There are no addresses for this rental shop!");
        } else {
            for (Address address : addresses) {
                System.out.println("Street: " + address.getStreet() + ", City: " + address.getCity() +
                        ", Country: " + address.getCountry());
            }
        }
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
