import Controller.AddressController;
import Controller.CarController;
import Controller.ContractController;
import Controller.PersonController;

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

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Add a car");
            System.out.println("2. Display all cars");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car");
            System.out.println("5. Add a customer");
            System.out.println("6. Delete a customer");
            System.out.println("7. Add an employee");
            System.out.println("8. Delete an employee");
            System.out.println("9. Add an address");
            System.out.println("10. Display all addresses");
            System.out.println("11. Delete an address");
            System.out.println("12. Add a contract");
            System.out.println("13. Display all contracts");
            System.out.println("14. Delete a contract");
            System.out.println("15. Search for a car");
            System.out.println("16. Rent a car");
            System.out.println("17. Return a car");
            System.out.println("18. Exit");

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
//                case 6:
//                    System.out.println("Enter employee name:");
//                    String employeeName = scanner.nextLine();
//                    System.out.println("Enter employee email:");
//                    String employeeEmail = scanner.nextLine();
//                    System.out.println("Enter employee email:");
//                    String employeeEmail = scanner.nextLine();
//                    System.out.println("Enter employee phone number:");
//                    String employeePhoneNumber = scanner.nextLine();
//                    System.out.println("Enter employee position:");
//                    String employeePosition = scanner.nextLine();
//                    boolean employeeAdded = personController.addPerson(0, employeeName, employeeEmail, employeePhoneNumber, employeePosition);
//                    if (employeeAdded) {
//                        System.out.println("Employee added successfully!");
//                    } else {
//                        System.out.println("Error adding employee.");
//                    }
//                    break;
//                case 10:
//                    employeeController.displayAllEmployees();
//                    break;
//                case 11:
//                    System.out.println("Enter employee ID:");
//                    int employeeId = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.println("Enter employee name:");
//                    employeeName = scanner.nextLine();
//                    System.out.println("Enter employee email:");
//                    employeeEmail = scanner.nextLine();
//                    System.out.println("Enter employee phone number:");
//                    employeePhoneNumber = scanner.nextLine();
//                    System.out.println("Enter employee position:");
//                    employeePosition = scanner.nextLine();
//                    boolean employeeUpdated = employeeController.updateEmployee(employeeId, employeeName, employeeEmail, employeePhoneNumber, employeePosition);
//                    if (employeeUpdated) {
//                        System.out.println("Employee updated successfully!");
//                    } else {
//                        System.out.println("Error updating employee.");
//                    }
//                    break;
//                case 12:
//                    System.out.println("Enter employee ID:");
//                    employeeId = scanner.nextInt();
//                    scanner.nextLine();
//                    boolean employeeDeleted = employeeController.deleteEmployee(employeeId);
//                    if (employeeDeleted) {
//                        System.out.println("Employee deleted successfully!");
//                    } else {
//                        System.out.println("Error deleting employee.");
//                    }
//                    break;
//            }
            }
        }while (choice != 18);
        scanner.close();
    }
}

