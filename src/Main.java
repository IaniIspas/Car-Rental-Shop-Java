//import Models.Car;
//import Models.Electric;
//
//public class Main {
//    public static void main(String[] args) {
//        Menu m = new Menu();
//        m.start();
//    }
//}

import Controller.AddressController;
import Models.*;
import Repository.AddressRepository;
import Repository.CarRepository;
import Repository.ContractRepository;
import Repository.PersonRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Models.Car;
import Models.Electric;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu m = new Menu();
        m.start();
    }
}