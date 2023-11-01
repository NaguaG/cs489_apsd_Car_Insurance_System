package miu.edu.car_insurance.dto.billing;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import miu.edu.car_insurance.dto.customer.CustomerResponse2;
import miu.edu.car_insurance.model.Customer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record BillingResponse(
        Long billingId, String billingMethod, Long cardNumber, LocalDate expiryDate, int securityCode, CustomerResponse2 customerResponse2
) {
}
