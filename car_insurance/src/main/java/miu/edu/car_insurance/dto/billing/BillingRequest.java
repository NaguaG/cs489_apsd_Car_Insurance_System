package miu.edu.car_insurance.dto.billing;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import miu.edu.car_insurance.model.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record BillingRequest(
        @NotBlank(message = "Billing method is required, not be null or empty !!!")
        String billingMethod,
        @NotNull(message = " Card number is required, not be null or empty !!!")
        Long cardNumber,
        @NotNull(message = "Expiry date is required, not be null or empty !!!")
        LocalDate expiryDate,
        @NotNull(message = "Security code is required, not be null or empty !!!")
        int securityCode

) {

}
