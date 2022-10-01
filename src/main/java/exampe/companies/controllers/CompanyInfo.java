package exampe.companies.controllers;

import exampe.companies.dto.CompanyDto;
import exampe.companies.dto.FilialDto;
import exampe.companies.model.Company;
import exampe.companies.services.CompanyService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.zkoss.zul.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyInfo extends Window {

    private CompanyService companyService;
    private static final long serialVersionUID = 1L;
    private ListModelList listModelList = new ListModelList();
    private ListModelList listModelListFilials = new ListModelList();

    private Textbox tbCompanyName;
    private Listbox companyListBox;
    private Listbox filialsListBox;
    private Textbox keywordBox;

    private Button sButton;
    private List<Company> companyList;

    public void onCreate() {
        ApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext((ServletContext) getDesktop().getWebApp().getNativeContext());

        companyService = ctx.getBean(CompanyService.class);
        sButton = (Button) this.getFellow("search");

        List<CompanyDto> productDtos = companyService.getCompanyList().stream().map(CompanyDto::new)
                .collect(Collectors.toList());

        if (productDtos.size() > 0) {
            populateListBox(productDtos);
        }
    }

    public void search() {
        keywordBox = (Textbox) this.getFellow("keywordBox");
        String keyword = keywordBox.getValue();
        if (keyword.isBlank() || keyword.isEmpty()) {
            List<CompanyDto> productDtos = companyService.getCompanyList().stream().map(CompanyDto::new)
                    .collect(Collectors.toList());

            if (productDtos.size() > 0) {
                populateListBox(productDtos);
            }
        } else {
            listModelList.clear();
            listModelListFilials.clear();
            Optional<Company> companyOptional = companyService.getCompanyByName(keyword);
            companyListBox = (Listbox) this.getFellow("lbCompany");
            if (companyOptional.isPresent()) {
                listModelList.add(companyOptional.get());
                companyListBox.setModel(listModelList);
            }
        }
    }

    private void populateListBox(List<CompanyDto> productDtos) {
        listModelList.clear();
        listModelListFilials.clear();
        for (CompanyDto company : productDtos) {
            listModelList.add(company);
        }
        companyListBox = (Listbox) this.getFellow("lbCompany");
        companyListBox.setModel(listModelList);

    }

    public void select() {
        Set<CompanyDto> selection = listModelList.getSelection();
        CompanyDto selected = selection.iterator().next();
        List<FilialDto> filials = selected.getFilials();
        listModelListFilials.clear();

        if (filials.size() > 0) {
            for (FilialDto filialDto : filials) {
                listModelListFilials.add(filialDto);
            }
            filialsListBox = (Listbox) this.getFellow("lbFilials");
            filialsListBox.setModel(listModelListFilials);
        }
    }
}
