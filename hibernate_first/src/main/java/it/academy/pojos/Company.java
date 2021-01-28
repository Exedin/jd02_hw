package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column
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
