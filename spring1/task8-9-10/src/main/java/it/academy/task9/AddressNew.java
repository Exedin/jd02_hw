package it.academy.task9;

import it.academy.task8_10.IAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository("addressNew")
@PropertySource("classpath:/app.properties")
public class AddressNew implements IAddress {

    private Long id;
    private String street;
    @Value("${address.city}")
    private String city;
    @Value("${address.country}")
    private String country;
    private String email;
    @Autowired
    private TestClass testClass;
}
