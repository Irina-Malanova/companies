package exampe.companies.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import exampe.companies.model.Address;

@Data
@NoArgsConstructor
public class FilialDto {
    private String name;
    private Address address;
}
