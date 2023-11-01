package miu.edu.car_insurance.dto.billing;

import miu.edu.car_insurance.dto.customer.CustomerResponse2;

import java.time.LocalDate;

public record BillingResponse2(
        Long billingId, String billingMethod, Long cardNumber, LocalDate expiryDate
) {
}
