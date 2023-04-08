package Service;

import Models.Address;
import Models.Company;
import Repository.CompanyRepository;

import java.util.List;

public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService() {
        this.companyRepository = new CompanyRepository();
    }

    public boolean addCompany(Company company) {
        return companyRepository.add(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    public Company getCompanyById(int id) {
        return companyRepository.getCompanyById(id);
    }

    public boolean updateCompany(Company updatedCompany) {
        return companyRepository.updateCompany(updatedCompany);
    }

    public boolean deleteCompany(int id) {
        return companyRepository.deleteCompany(id);
    }
}