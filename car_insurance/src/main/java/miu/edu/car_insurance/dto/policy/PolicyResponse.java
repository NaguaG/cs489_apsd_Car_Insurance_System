package miu.edu.car_insurance.dto.policy;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import miu.edu.car_insurance.dto.coverage.CoverageResponse;
import miu.edu.car_insurance.dto.payment.PaymentResponse;
import miu.edu.car_insurance.dto.quote.QuoteResponse;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.model.Vehicle;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record PolicyResponse(
        Long policyId, String policyNumber, LocalDate effectiveDate, LocalDate createdDate,
        LocalDate expiredDate, Double totalAmount, boolean active, Vehicle vehicle,
        List<CoverageResponse> coverages, List<QuoteResponse> quotes, List<PaymentResponse> payments
) {

}
