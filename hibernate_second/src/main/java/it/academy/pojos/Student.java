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
@Table(name= "STUDENT")
@DiscriminatorValue("S")
@Data

public class Student extends Person {


    private String faculty;

    private Double mark;
}
