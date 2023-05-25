package Controller;

import Models.Person;
import Service.PersonService;

import java.util.List;

public class PersonController {
    private final PersonService personService;

    public PersonController() {
        this.personService = new PersonService();
    }

    public Person getPersonById(int id, int type) throws Exception {
        return personService.getPersonById(id, type);
    }

    public void displayAllPersons() throws Exception {
        List<Person> persons = personService.findAllPersons();

        if (!persons.isEmpty()) {
            System.out.println("All Persons:");
            for (Person person : persons) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("No persons found.");
        }
    }

    public Person searchPersonByEmail(String email) throws Exception {
        return personService.searchPersonByEmail(email);
    }

    public Person searchPersonByNameAndPhone(String name, String phone) throws Exception {
        return personService.searchPersonByNameAndPhone(name, phone);
    }

    public Person findPerson(String name, String phone, String email) throws Exception{
            return personService.findPerson(name, phone, email);
    }

    public void createPerson(Person person, int type) throws Exception {
        personService.createPerson(person, type);
    }

    public void updatePerson(Person person, int type) throws Exception {
        personService.updatePerson(person, type);
    }

    public void deletePerson(int id, int type) throws Exception {
        personService.deletePerson(id, type);
    }

    public void deleteEmployeeByEmail(String email) throws Exception {
        personService.deleteEmployeeByEmail(email);
    }
}
