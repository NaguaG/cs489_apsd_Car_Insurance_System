package miu.edu.car_insurance.dto.billing;

import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Customer;

import java.time.LocalDate;

public record BillingRequest2(
        Long billingId,
        String billingMethod,
        Long cardNumber,
        LocalDate expiryDate,
        int securityCode
) {
}
