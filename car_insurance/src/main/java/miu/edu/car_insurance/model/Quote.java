package miu.edu.car_insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quoteId;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;
    public Quote(Double price){
        this.price = price;
    }

}
