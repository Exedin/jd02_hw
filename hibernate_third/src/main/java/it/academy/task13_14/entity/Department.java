package it.academy.task13_14.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "T_DEP")
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GenericGenerator(name="gen-uuid",strategy = "uuid")
    @GeneratedValue(generator = "gen-uuid")
    @Column(name = "D_ID")
    private String id;

    @Column(name="D_NAME")
    private  String name;

    @Column(name = "D_PHONE")
    private String phone;

    @Column(name="D_DESC")
    private String description;
}
