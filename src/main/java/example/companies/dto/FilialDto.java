package example.companies.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import example.companies.model.Address;

@Data
@NoArgsConstructor
public class FilialDto {
    private String name;
    private Address address;
}
