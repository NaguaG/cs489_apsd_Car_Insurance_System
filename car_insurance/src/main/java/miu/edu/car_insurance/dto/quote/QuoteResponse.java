package miu.edu.car_insurance.dto.quote;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import miu.edu.car_insurance.model.Policy;

public record QuoteResponse(
        Long quoteId, Double price
) {
}
