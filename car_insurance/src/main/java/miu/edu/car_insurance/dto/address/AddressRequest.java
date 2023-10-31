package miu.edu.car_insurance.dto.address;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Customer;

public record AddressRequest(
        @NotBlank(message = "Street is required, not be null or empty !!!")
        String street,
        @NotBlank(message = "City is required, not be null or empty !!!")
        String city,
        @NotBlank(message = "State is required, not be null or empty !!!")
        String state,
        @NotBlank(message = "Zipcode is required, not be null or empty !!!")
        String zipcode

) {
}
