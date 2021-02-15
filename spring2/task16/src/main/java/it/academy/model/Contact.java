package it.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Contact {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
