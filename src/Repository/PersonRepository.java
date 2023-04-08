package Repository;

import Models.Person;

import java.util.ArrayList;

public class PersonRepository {
    private ArrayList<Person> persons = new ArrayList<Person>();
    public boolean add(Person person) {
        try {
            persons.add(person);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Person get(String phone) {
        for (Person person : persons) {
            if(person.getPhone() == phone)
                return person;
        }
        return null;
    }
    public ArrayList<Person> getAllPersons() {
        return persons;
    }

    public boolean update(int i, Person person) {
        try {
            persons.set(i, person);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean delete(String email) {
        try {
            int cnt = 0;
            for (Person person : persons) {
                if(person.getEmail().equals(email)) {
                    persons.remove(cnt);
                    return true;
                }
                cnt ++;
            }
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}

