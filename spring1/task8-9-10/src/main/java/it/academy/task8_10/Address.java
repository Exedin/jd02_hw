package it.academy.task8_10;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Address implements IAddress {

    private Long id;
    private String street;
    private String city;
    private String country;
    private String email;
}
