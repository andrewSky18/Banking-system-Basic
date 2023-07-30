package crud.crud.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder

@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private Long nationalId;

    private short age;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Customer_id")
    @JsonIgnore

    private Set<Loan> loanSet;

    @JsonIgnore

    @ManyToOne
    @JoinColumn(name = "Facility_id")

    private Facility facility;


    public static Customer CreateCustomer(CustomerDTO customerDTO , Facility facility) {
        Customer customer = Customer.builder()
                .name(customerDTO.getName())
                .nationalId(customerDTO.getNationalId())
                .age(customerDTO.getAge())
                .facility(facility)
                .build();
        return customer;
    }


    public static Customer updateCustomer(CustomerDTO customerDTO,Customer customer) {
                customer.setName(customerDTO.getName());
                customer.setAge(customerDTO.getAge());
                customer.setNationalId(customerDTO.getNationalId());
        return customer;
    }
}