package miu.edu.car_insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String make;
    private Long mileage;
    private String vinNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    public Vehicle(String make, Long mileage, String vinNumber, LocalDate createdDate) {
        this.make = make;
        this.mileage = mileage;
        this.vinNumber = vinNumber;
        this.createdDate = createdDate;
    }
}
