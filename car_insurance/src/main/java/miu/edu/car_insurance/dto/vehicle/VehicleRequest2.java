package miu.edu.car_insurance.dto.vehicle;

import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.model.Policy;

import java.time.LocalDate;

public record VehicleRequest2(
        Long vehicleId,
        String make,
        Long mileage,
        String vinNumber,
        Policy policy
) {
}
