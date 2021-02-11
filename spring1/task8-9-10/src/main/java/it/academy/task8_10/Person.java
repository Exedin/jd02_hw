package it.academy.task8_10;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Person {
    private Integer id;
    private  Integer age;
    private String name;
    private String surname;

    @Autowired
    private IAddress address;

}
