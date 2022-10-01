package example.companies.dto;

import example.companies.model.Address;
import example.companies.model.Filial;
import example.companies.model.Type;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import example.companies.model.Company;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CompanyDto {
    private Long id;

    @NotNull(message = "Компания должна иметь название")
    @Length(min = 3, max = 255, message = "Длина названия должна составлять 3-255 символов")
    private String name;
    private Address address;
    private List<FilialDto> filials = new ArrayList<>();
    private Type type;

    public CompanyDto(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.address = company.getAddress();
        for (Filial filial : company.getFilials()) {
            FilialDto filialDto = new FilialDto();
            filialDto.setAddress(filial.getAddress());
            filialDto.setName(filial.getName());
            filials.add(filialDto);
        }
        this.type = company.getType();
    }
}
