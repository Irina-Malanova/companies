package example.companies.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class CompanyError {
    private List<String> messages;
    private Date date;

    public CompanyError(List<String> messages) {
        this.messages = messages;
        this.date = new Date();
    }

    public CompanyError(String message) {
        this(List.of(message));
    }

    public CompanyError(String... messages) {
        this(Arrays.asList(messages));
    }
}
