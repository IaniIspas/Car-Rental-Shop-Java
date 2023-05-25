package Service;

import Models.Person;
import Models.Customer;
import Models.Employee;
import Repository.PersonRepository;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService() {
        this.personRepository = PersonRepository.getInstance();
    }

    public Person getPersonById(int id, int type) throws Exception {
        return personRepository.findById(id, type);
    }

    public List<Person> findAllPersons() throws Exception {
        return personRepository.findAll();
    }

    public Person searchPersonByEmail(String email) throws Exception {
        return personRepository.findByEmail(email);
    }

    public Person searchPersonByNameAndPhone(String name, String phone) throws Exception {
        return personRepository.findByNameAndPhone(name, phone);
    }

    public Person findPerson(String name, String phone, String email) throws Exception {
        return personRepository.findPerson(name, phone, email);
    }

    public void createPerson(Person person, int type) throws Exception {
        personRepository.create(person, type);
    }

    public void updatePerson(Person person, int type) throws Exception {
        personRepository.update(person, type);
    }

    public void deletePerson(int id, int type) throws Exception {
        personRepository.delete(id, type);
    }

    public void deleteEmployeeByEmail(String email) throws Exception {
        personRepository.deleteEmployeeByEmail(email);
    }
}
