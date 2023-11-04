package miu.edu.car_insurance.dto.customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import miu.edu.car_insurance.dto.address.AddressRequest;
import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingRequest2;
import miu.edu.car_insurance.dto.vehicle.VehicleRequest;
import miu.edu.car_insurance.dto.vehicle.VehicleRequest2;
import miu.edu.car_insurance.model.Billing;

import java.time.LocalDate;
import java.util.List;

public record CustomerRequest(
    @NotBlank(message = "Customer firstname is required, not be null or empty !!!")
    String firstName,
    @NotBlank(message = "Customer lastname is required, not be null or empty !!!")
    String lastName,
    @NotNull(message = "Customer date of birth is required, not be null or empty !!!")
    LocalDate dob,
    @NotBlank(message = "Customer ssn is required, not be null or empty !!!")
    String ssn,
    @NotBlank(message = "Customer gender is required, not be null or empty !!!")
    String gender,
    @NotBlank(message = "Customer email is required, not be null or empty !!!")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
    String email,
    @NotNull(message = "Customer license issued date is required, not be null or empty !!!")
    LocalDate licenseIssuedDate,
    @NotNull(message = "Customer license issued state is required, not be null or empty !!!")
    String licenseIssuedState,
    LocalDate accountCreatedDate,
    boolean active,
//    List<VehicleRequest2> vehicles,
 //   @NotBlank(message = "Address is required, not be null or empty !!!")
    AddressRequest address
    //@NotBlank(message = "Billing information is required, not be null or empty !!!")
  //  List<BillingRequest2> billing
    ){

}
