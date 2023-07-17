package crud.crud.domain;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Builder

@Table(name="Facility")
public class Facility {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String address;

    @OneToMany
    private Set<Customer> customerSet;


    public static Facility CreateFacility(FacilityDTO facilityDTO) {
        Facility facility = Facility.builder()
                .name(facilityDTO.getName())
                .address(facilityDTO.getAddress())
                .build();
        return facility;
    }

}