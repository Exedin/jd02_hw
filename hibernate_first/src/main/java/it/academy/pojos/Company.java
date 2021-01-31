package it.academy.pojos;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    @Getter
    @Setter
    private String id;
    @Column
    @Getter
    @Setter
    private String name;
    @Column
    @Access(AccessType.FIELD)
    private String bank;
    @Column(name = "bank_account")
    @Access(AccessType.FIELD)
    private String bankAccount;

    private Address address;

    @Transient
    public boolean isNew() {
        return id == null;
    }

}
