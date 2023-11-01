package miu.edu.car_insurance.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coverages")
public class Coverage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageId;
    private String coverageName;
    private Double coveragePrice;
    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    public Coverage(String coverageName, Double coveragePrice){
        this.coverageName = coverageName;
        this.coveragePrice = coveragePrice;
    }


}
