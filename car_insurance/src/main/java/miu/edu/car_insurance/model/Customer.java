package miu.edu.car_insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @OneToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
    @OneToMany(mappedBy = "customer")
    private List<Quote> quotes;
    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

}
