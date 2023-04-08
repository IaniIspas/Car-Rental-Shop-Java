package Repository;

import Models.Car;
import Models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    private List<Company> companies = new ArrayList<Company>();
    public CompanyRepository() {
        this.companies = new ArrayList<>();
    }

    public boolean add(Company company) {
        try {
            companies.add(company);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public List<Company> getAllCompanies() {
        return companies;
    }

    public Company getCompanyById(int id) {
        for (Company company : companies) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    public boolean updateCompany(Company updatedCompany) {
        for (Company company : companies) {
            if (company.getId() == updatedCompany.getId()) {
                companies.set(companies.indexOf(company), updatedCompany);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCompany(int id) {
        for (Company company : companies) {
            if (company.getId() == id) {
                companies.remove(company);
                return true;
            }
        }
        return false;
    }


}