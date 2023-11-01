package miu.edu.car_insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.car_insurance.dto.address.AddressResponse;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String ssn;
    private String gender;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate licenseIssuedDate;
    private String licenseIssuedState;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate accountCreatedDate;
    private boolean active;
    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "customer")
    private List<Billing> billings;

    public Customer(String firstName, String lastName, LocalDate dob, String ssn, String gender,
                    String email, LocalDate licenseIssuedDate, String licenseIssuedState, Address address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.ssn =ssn;
        this.gender = gender;
        this.email = email;
        this.licenseIssuedDate = licenseIssuedDate;
        this.licenseIssuedState = licenseIssuedState;
        this.address = address;

    }

}
