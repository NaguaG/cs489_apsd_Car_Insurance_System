package miu.edu.car_insurance.dto.address;

import jakarta.validation.constraints.NotBlank;

public record AddressResponse(
       Long addressId, String street, String city, String state, String zipcode
) {
}
