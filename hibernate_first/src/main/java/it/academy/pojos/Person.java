package it.academy.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_PERSON")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "P_ID")
    private Integer id;
    @Column(name = "P_AGE")
    private Integer age;
    @Column(name = "P_NAME")
    private String name;
    @Column(name = "P_SURNAME")
    private String surname;

}
