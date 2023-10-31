package miu.edu.car_insurance.dto.customer;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.dto.address.AddressRequest;
import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.model.Billing;

import java.time.LocalDate;

public record CustomerRequest(
    @NotBlank(message = "Customer firstname is required, not be null or empty !!!")
    String firstName,
    @NotBlank(message = "Customer lastname is required, not be null or empty !!!")
    String lastName,
    @NotBlank(message = "Customer date of birth is required, not be null or empty !!!")
    LocalDate dob,
    @NotBlank(message = "Customer ssn is required, not be null or empty !!!")
    String ssn,
    @NotBlank(message = "Customer gender is required, not be null or empty !!!")
    String gender,
    @NotBlank(message = "Customer email is required, not be null or empty !!!")
    String email,
    @NotBlank(message = "Customer license issued date is required, not be null or empty !!!")
    LocalDate licenseIssuedDate,
    @NotBlank(message = "Customer license issued state is required, not be null or empty !!!")
    String licenseIssuedState,
    @NotBlank(message = "Address is required, not be null or empty !!!")
    AddressRequest address,
    @NotBlank(message = "Billing information is required, not be null or empty !!!")
    BillingRequest billing
    ){

}
