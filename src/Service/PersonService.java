package Service;

import Models.Car;
import Models.Customer;
import Models.Employee;
import Models.Person;
import Repository.PersonRepository;

import java.util.ArrayList;

public class PersonService {
    private PersonRepository personRepository;
    private static int reg_no;

    public PersonService() {
        this.personRepository = new PersonRepository();
        reg_no++;
    }

    public boolean addPerson(int t, String name, String address, String phone, String email, double value) {
        Person person;
        if(t == 0)
            person = new Employee(name ,address, phone, email, value);
        else
            person = new Customer(name, address, phone, email, value);
        person.setId(reg_no);
        return this.personRepository.add(person);
    }

    public Person getPersonByPhone(String phone) {
        return personRepository.get(phone);
    }

    public ArrayList<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }

    public boolean updatePerson(int i, Person person) {
        return personRepository.update(i, person);
    }

    public boolean deletePerson(String email) {
        return personRepository.delete(email);
    }
}
