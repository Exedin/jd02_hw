package it.academy.pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "EMPLOYEE")
@DiscriminatorValue("E")
@Data
public class Employeer extends Person{

    private String company;

    private Double salary;
}
