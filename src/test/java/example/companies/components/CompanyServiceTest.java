package example.companies.components;

import example.companies.model.Company;
import example.companies.services.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = "spring.main.lazy-initialization=true")
public class CompanyServiceTest {
    @Autowired
    private CompanyService companyService;

    @Test
    @Sql("/sql/createRep.sql")
    void testCompanyService() {
        List<Company> companyList = companyService.getCompanyListByPage(0, 10);
        assertEquals(1, companyList.size());
    }
}
