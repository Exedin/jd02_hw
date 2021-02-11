package it.academy.task9;

import it.academy.task8_10.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;



@Data
@NoArgsConstructor
@AllArgsConstructor
@TestAnnotation
public class testClass {
    @Autowired
    private Address address;
}


