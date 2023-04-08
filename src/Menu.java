import Controller.*;
import Models.Address;
import Models.Company;
import Models.Customer;

import java.util.Date;
import java.util.Scanner;


public class Menu {
    private CarController carController;
    private ContractController contractController;
    private AddressController addressController;
    private CompanyController companyController;
    private PersonController personController;

    public Menu() {
        carController = new CarController();
        contractController = new ContractController();
        addressController = new AddressController();
        personController = new PersonController();
        companyController = new CompanyController();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        Address a = new Address("Mihai Bravu", "Targoviste", "Romania");
        Company c = new Company(1, "TgvAUTO", a);
        companyController.addCompany(c);
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Display all cars");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car by id");
            System.out.println("5. Add a customer");
            System.out.println("6. Add an employee");
            System.out.println("7. Delete an employee by email");
            System.out.println("8. Display all persons in the rental shop");
            System.out.println("9. Add a contract");
            System.out.println("10. Search for a car by make and model");
            System.out.println("11. Search for a car by year and color");
            System.out.println("12. Show company details");
            System.out.println("13. Exit");
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
                    System.out.println("What type of car do you want to rent ? 0 - Electric / 1 - Gasoline / 2 - Diesel");
                    Integer t = scanner.nextInt();
                    boolean carAdded = false;
                    if (t == 0) {
                        System.out.println("Enter range : ");
                        Integer value = scanner.nextInt();
                        carAdded = carController.addCar(0, make, model, year, color, rentalPrice, value);
                    } else if (t == 1) {
                        System.out.println("Enter fuelCapacity");
                        Integer value = scanner.nextInt();
                        carAdded = carController.addCar(1, make, model, year, color, rentalPrice, value);
                    } else if (t == 2) {
                        System.out.println("Enter fuelCapacity : ");
                        Integer value = scanner.nextInt();
                        carAdded = carController.addCar(2, make, model, year, color, rentalPrice, value);
                    }
                    if (carAdded) {
                        System.out.println("Car added successfully!");
                    } else {
                        System.out.println("Error adding car.");
                    }
                    break;
                case 2:
                    carController.displayAllCars();
                    break;
                case 3:
                    System.out.println("Enter car ID:");
                    int carId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter make:");
                    make = scanner.nextLine();
                    System.out.println("Enter model:");
                    model = scanner.nextLine();
                    System.out.println("Enter year:");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter color:");
                    color = scanner.nextLine();
                    System.out.println("Enter rental price:");
                    rentalPrice = scanner.nextDouble();
                    scanner.nextLine();
                    boolean carUpdated = carController.updateCar(carId, make, model, year, color, rentalPrice);
                    if (carUpdated) {
                        System.out.println("Car updated successfully!");
                    } else {
                        System.out.println("Error while trying to add a car!");
                    }
                    break;
                case 4:
                    System.out.println("Enter car ID:");
                    carId = scanner.nextInt();
                    scanner.nextLine();
                    boolean carDeleted = carController.deleteCar(carId);
                    if (carDeleted) {
                        System.out.println("Car deleted successfully!");
                    } else {
                        System.out.println("Error deleting car.");
                    }
                    break;
                case 5:
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter customer email:");
                    String customerEmail = scanner.nextLine();
                    System.out.println("Enter customer address:");
                    String customerAddress = scanner.nextLine();
                    System.out.println("Enter customer phone number:");
                    String customerPhoneNumber = scanner.nextLine();
                    System.out.println("Enter customer salary");
                    Double customerSalay = scanner.nextDouble();
                    boolean customerAdded = personController.addPerson(1, customerName, customerEmail, customerAddress, customerPhoneNumber, customerSalay);
                    if (customerAdded) {
                        System.out.println("Customer added successfully!");
                    } else {
                        System.out.println("Error adding customer.");
                    }
                    break;
                case 6:
                    System.out.println("Enter employee name:");
                    String employeeName = scanner.nextLine();
                    System.out.println("Enter employee address:");
                    String employeeAddress = scanner.nextLine();
                    System.out.println("Enter employee email:");
                    String employeeEmail = scanner.nextLine();
                    System.out.println("Enter employee phone number:");
                    String employeePhoneNumber = scanner.nextLine();
                    System.out.println("Enter employee salary:");
                    Double employeeSalary = scanner.nextDouble();
                    boolean employeeAdded = personController.addPerson(0, employeeName, employeeAddress, employeeEmail, employeePhoneNumber, employeeSalary);
                    if (employeeAdded) {
                        System.out.println("Employee added successfully!");
                    } else {
                        System.out.println("Error adding employee.");
                    }
                    break;
                case 7:
                    System.out.println("Enter employee email:");
                    employeeEmail = scanner.nextLine();
                    boolean employeeDeleted = personController.deletePerson(employeeEmail);
                    if (employeeDeleted) {
                        System.out.println("Employee removed successfully!");
                    } else {
                        System.out.println("Error while removing employee!");
                    }
                    break;
                case 8:
                    personController.displayAllPersons();
                    break;
                case 9:
                    System.out.println("Enter customer ID:");
                    int customerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter employee ID:");
                    int employeeID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter car ID:");
                    carId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter startDate:");
                    String startDate = scanner.nextLine();
                    System.out.println("Enter endDate:");
                    String endDate = scanner.nextLine();
                    System.out.println("Enter rental price:");
                    rentalPrice = scanner.nextDouble();
                    scanner.nextLine();
                    boolean contractAdded = contractController.addContract(customerId, employeeID, carId, startDate, endDate);
                    if (contractAdded) {
                        System.out.println("Contract added successfully!");
                    } else {
                        System.out.println("Error adding contract.");
                    }
                    break;
                case 10:
                    System.out.println("Enter make:");
                    make = scanner.nextLine();
                    System.out.println("Enter model:");
                    model = scanner.nextLine();
                    carController.displayCarByMakeAndModel(make, model);
                    break;
                case 11:
                    System.out.println("Enter year:");
                    year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter color:");
                    color = scanner.nextLine();
                    carController.displayCarByYearAndColor(year, color);
                    break;
                case 12:
                    System.out.println("Company name: " + c.getName());
                    System.out.println("Address: " + a.getStreet() + ", " + a.getCity() + ", " + a.getCountry());
            }
        }while (choice != 13);
        scanner.close();
    }
}

