package miu.edu.car_insurance.dto.payment;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import miu.edu.car_insurance.model.Policy;

import java.time.LocalDate;

public record PaymentResponse(
        Long paymentId, LocalDate paymentDate, Double paymentAmount, String paymentType
) {
}
