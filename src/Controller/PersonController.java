package Controller;

import Models.Car;
import Models.Customer;
import Models.Employee;
import Models.Person;
import Service.PersonService;

import java.util.ArrayList;

public class PersonController {
    private PersonService personService;
    public PersonController() {
        this.personService = new PersonService();
    }
    public boolean addPerson(int t, String name, String address, String phone, String email, double value) {
        return personService.addPerson(t, name, address, phone, email, value);
    }
    public Person getPersonByPhone(String phone) {
        return personService.getPersonByPhone(phone);
    }
    public ArrayList<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    public void displayAllPersons() {
        ArrayList<Person> persons = personService.getAllPersons();
        if (persons.isEmpty()) {
            System.out.println("There are no persons currently in the rental shop!");
        } else {
            for (Person person : persons) {
                System.out.println("Name: " + person.getName() + ", Address: " + person.getAddress() +
                        ", Phone: " + person.getPhone() + ", Email: " + person.getEmail());
            }
        }
    }
    public boolean updatePerson(int id, String name, String address, String phone, String email, double value) {
        Person person = personService.getPersonByPhone(phone);
        person.setId(id);
        person.setName(name);
        person.setAddress(address);
        person.setEmail(email);
        if(person instanceof Employee) {
            ((Employee)person).setSalary(value);
        }
        else {
            ((Customer)person).setBalance(value);
        }
        return personService.updatePerson(id, person);
    }
    public boolean deletePerson(String email) {
        return personService.deletePerson(email);
    }
}