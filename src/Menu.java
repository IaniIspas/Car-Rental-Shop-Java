import Controller.*;
import Models.*;
import Service.AuditService;

import java.util.Date;
import java.util.Scanner;


public class Menu {
    private CarController carController;
    private ContractController contractController;
    private AddressController addressController;
    private PersonController personController;

    public Menu() {
        carController = new CarController();
        contractController = new ContractController();
        addressController = new AddressController();
        personController = new PersonController();
    }

    public void start() throws Exception {
        Scanner scanner = new Scanner(System.in);
        AuditService auditService = new AuditService();
        int globalId = 1;
        int personId = 1;
        int choice;

        Address address = new Address(1, "Diaconu Coresi", "Targoviste", "Romania");
        addressController.createAddress(address);

        do {
            System.out.println("Please select an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Delete a car by id");
            System.out.println("3. Search a car by id");
            System.out.println("4. Add a customer");
            System.out.println("5. Add an employee");
            System.out.println("6. Delete a person by email");
            System.out.println("7. Search for a customer by name");
            System.out.println("8. Search for a person by name and phone");
            System.out.println("9. Search for person by name, phone and email");
            System.out.println("10. Update the location address");
            System.out.println("12. Display all persons in the rental shop");
            System.out.println("13. Display all cars");
            System.out.println("14. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter make:");
                    String make = scanner.nextLine();
                    System.out.println("Enter model:");
                    String model = scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter color:");
                    String color = scanner.nextLine();
                    System.out.println("Enter rental price:");
                    Double rentalPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("What type of car do you want to add ? 1 - Diesel / 2 - Electric / 3 - Gasoline");
                    Integer t = scanner.nextInt();
                    boolean carAdded = false;
                    if (t == 2) {
                        System.out.println("Enter range : ");
                        Integer value = scanner.nextInt();
                        Car car = new Electric(globalId++,make, model, year, color, rentalPrice, value);
                        carController.createCar(car, 0);
                        auditService.writeToAuditLog("Add new Electric car");
                    } else if (t == 3) {
                        System.out.println("Enter fuelCapacity");
                        Double value = scanner.nextDouble();
                        Car car = new Gasoline(globalId++, make, model, year, color, rentalPrice, value);
                        carController.createCar(car, 1);
                        auditService.writeToAuditLog("Add new Gasoline car");
                    } else if (t == 1) {
                        System.out.println("Enter fuelCapacity : ");
                        Double value = scanner.nextDouble();
                        Car car = new Diesel(globalId++, make, model, year, color, rentalPrice, value);
                        carController.createCar(car, 1);
                        auditService.writeToAuditLog("Add new Diesel car");
                    }
                    else {
                        System.out.println("Enter a valid choice next time!");
                    }
                    break;
                case 2:
                    System.out.println("What type of car do you want to delete? 1 - Diesel / 2 - Electric / 3 - Gasoline");
                    t = scanner.nextInt();
                    System.out.println("Enter car ID:");
                    int carId = scanner.nextInt();
                    scanner.nextLine();
                    carController.deleteCar(carId, t);
                    auditService.writeToAuditLog("Deleted a car");
                    break;
                case 3:
                    System.out.println("What type of car do you want to search for? 1 - Diesel / 2 - Electric / 3 - Gasoline");
                    t = scanner.nextInt();
                    System.out.println("Enter car ID:");
                    carId = scanner.nextInt();
                    scanner.nextLine();
                    Car c = carController.getCarById(carId, t);
                    System.out.println(c);
                    auditService.writeToAuditLog("Search for a car");
                    break;
                case 4:
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter customer email:");
                    String customerEmail = scanner.nextLine();
                    System.out.println("Enter customer phone number:");
                    String customerPhoneNumber = scanner.nextLine();
                    System.out.println("Enter customer balance");
                    Double customerBalance = scanner.nextDouble();
                    Person customer = new Customer(personId++,customerName, customerEmail, customerPhoneNumber, customerBalance);
                    personController.createPerson(customer, 1);
                    auditService.writeToAuditLog("Add a new customer");
                    break;
                case 5:
                    System.out.println("Enter employee name:");
                    String employeeName = scanner.nextLine();
                    System.out.println("Enter employee email:");
                    String employeeEmail = scanner.nextLine();
                    System.out.println("Enter employee phone number:");
                    String employeePhoneNumber = scanner.nextLine();
                    System.out.println("Enter employee salary");
                    Double employeeSalary = scanner.nextDouble();
                    Person employee = new Employee(personId++,employeeName, employeeEmail, employeePhoneNumber, employeeSalary);
                    personController.createPerson(employee, 2);
                    auditService.writeToAuditLog("Add a new employee");
                    break;
                case 6:
                    System.out.println("Enter employee email:");
                    employeeEmail = scanner.nextLine();
                    personController.deleteEmployeeByEmail(employeeEmail);
                    auditService.writeToAuditLog("Delete an employee");
                    break;
                case 7:
                    System.out.print("Enter the email: ");
                    String email = scanner.nextLine();

                    Person person = personController.searchPersonByEmail(email);

                    if (person != null) {
                        System.out.println("Person found:");
                        System.out.println(person);
                    } else {
                        System.out.println("Person not found.");
                    }

                    auditService.writeToAuditLog("Search for a person");
                    break;
                case 8:
                    System.out.print("Enter the name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the phone: ");
                    String phone = scanner.nextLine();
                    person = personController.searchPersonByNameAndPhone(name, phone);

                    if (person != null) {
                        System.out.println("Person found:");
                        System.out.println(person);
                        auditService.writeToAuditLog("Search for a car");
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;
                case 9:
                    System.out.print("Enter the name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter the phone: ");
                    phone = scanner.nextLine();
                    System.out.print("Enter the email: ");
                    email = scanner.nextLine();
                    person = personController.findPerson(name, phone, email);
                    if (person != null) {
                        System.out.println("Person found:");
                        System.out.println(person);
                        auditService.writeToAuditLog("Search for a car");
                    } else {
                        System.out.println("Person not found.");
                    }

                    break;
                case 10:
                    break;
                case 11:
                    System.out.print("Enter the new street: ");
                    String newStreet = scanner.nextLine();
                    System.out.print("Enter the new city: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter the new country: ");
                    String newCountry = scanner.nextLine();
                    Address newAddress = new Address(2, newStreet, newCity, newCountry);
                    addressController.updateAddress(newAddress);
                    auditService.writeToAuditLog("Update the address");
                    break;
                case 12:
                    personController.displayAllPersons();
                    auditService.writeToAuditLog("Display all persons");
                    break;
                case 13:
                    carController.displayAllCars();
                    auditService.writeToAuditLog("Display all cars");
                    break;
            }
        }while (choice != 14);
        scanner.close();
    }
}