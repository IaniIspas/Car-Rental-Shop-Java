package Controller;
import Models.Address;
import Models.Car;
import Models.Company;
import Service.CompanyService;

import java.util.List;
import java.util.Scanner;

public class CompanyController {
    private final CompanyService companyService;

    public CompanyController() {
        this.companyService = new CompanyService();
    }

    public boolean addCompany(Company c) {
        boolean isAdded = companyService.addCompany(c);
        if (isAdded) {
            System.out.println("Company added successfully!");
        } else {
            System.out.println("Error adding company.");
        }
        return isAdded;
    }

    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    public Company getCompanyById(int id) {
        return companyService.getCompanyById(id);
    }

    public boolean updateCompany(Company company) {
        return companyService.updateCompany(company);
    }

    public boolean deleteCompany(int id) {
        return companyService.deleteCompany(id);
    }
}