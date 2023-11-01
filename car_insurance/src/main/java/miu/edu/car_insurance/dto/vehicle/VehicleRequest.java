package miu.edu.car_insurance.dto.vehicle;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.model.Policy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record VehicleRequest(
        @NotBlank(message = "Made year is required, not be blank or null !!!")
        String make,
        @NotBlank(message = "Mileage is required, not be blank or null !!!")
        Long mileage,
        @NotBlank(message = "Vin number is required, not be blank or null !!!")
        String vinNumber,
        @NotBlank(message = "Created date is required, not be blank or null !!!")
        LocalDate createdDate

) {

}
