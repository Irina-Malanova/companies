package example.companies.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import example.companies.model.Company;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.main.lazy-initialization=true")
public class RepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @Sql("/sql/createRep.sql")
    void testFindRecordsInCompanyRepository() {
        List<Company> companyList = companyRepository.findAll();
        assertEquals(1, companyList.size());
    }
}
