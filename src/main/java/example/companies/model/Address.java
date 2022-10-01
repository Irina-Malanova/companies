package example.companies.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String post_index;
    private String city;
    private String street;
    private String house;
    private String flat;

    @Override
    public String toString() {
        return
                post_index +
                        ", " + city +
                        ", " + street +
                        ", " + house +
                        ", " + flat;
    }
}
