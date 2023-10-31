package miu.edu.car_insurance.dto.policy;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.dto.coverage.CoverageRequest;
import miu.edu.car_insurance.dto.payment.PaymentRequest;
import miu.edu.car_insurance.dto.quote.QuoteRequest;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.repo.QuoteRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public record PolicyRequest(
        @NotBlank(message = " Policy number is required, not be null or empty !!!")
        String policyNumber,
        @NotBlank(message = "Effective is required, not be null or empty !!!")
        LocalDate effectiveDate,
        @NotBlank(message = " Created date is required, not be null or empty !!!")
        LocalDate createdDate,
        @NotBlank(message = " Expiry date is required, not be null or empty !!!")
        LocalDate expiredDate,
        @NotBlank(message = " Total amount is required, not be null or empty !!!")
        Double totalAmount,

        List<CoverageRequest> coverages,
        List<QuoteRequest> quotes,
        List<PaymentRequest> payments

) {

}
