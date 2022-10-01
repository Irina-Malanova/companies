package exampe.companies.services;

import exampe.companies.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exampe.companies.model.Company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private List<Company> companyList = new ArrayList<>();
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getCompanyList() {
        companyList = companyRepository.findAll();
        return companyList;
    }

    public Optional<Company> getCompanyByName(String name) {
        return companyRepository.findByName(name);

    }

    public List<Company> getCompanyListByPage(int pageNum, int pageSize) {
        companyList = getCompanyList();
        int first = pageNum * pageSize;
        try {
            return companyList.subList(first, first + pageSize);
        } catch (IndexOutOfBoundsException e) {
            if (companyList.size() < first || companyList.size() == 0)
                return Collections.emptyList();
            if (companyList.size() < first + pageSize) {
                return companyList.subList(first, companyList.size());
            }
        }
        return Collections.emptyList();
    }

    public void setProductList(List<Company> companyList) {
        this.companyList = companyList;
    }

}
