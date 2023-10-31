package miu.edu.car_insurance.dto.quote;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Policy;

public record QuoteRequest(
        @NotBlank(message = "Quote price is required !!!")
        Double price

) {
}
