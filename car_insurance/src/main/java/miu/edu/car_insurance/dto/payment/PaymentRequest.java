package miu.edu.car_insurance.dto.payment;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Policy;

import java.time.LocalDate;

public record PaymentRequest(
        LocalDate paymentDate,
        @NotBlank(message = "Amount is required, not be null or empty !!!")
        Double paymentAmount,
        @NotBlank(message = "Payment type is required, not be null or empty !!!")
        String paymentType

) {
}
