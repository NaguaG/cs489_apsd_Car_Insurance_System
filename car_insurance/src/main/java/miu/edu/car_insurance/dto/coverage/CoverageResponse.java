package miu.edu.car_insurance.dto.coverage;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import miu.edu.car_insurance.model.Policy;

public record CoverageResponse(
        Long coverageId, String coverageName, Double coveragePrice
) {
}
