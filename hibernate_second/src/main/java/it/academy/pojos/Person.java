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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSON_TYPE")
@DiscriminatorValue("P")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "P_ID")
    private Integer id;
    @Column(name = "P_NAME")
    private String name;
    @Column(name = "P_SURNAME")
    private String surname;

}
