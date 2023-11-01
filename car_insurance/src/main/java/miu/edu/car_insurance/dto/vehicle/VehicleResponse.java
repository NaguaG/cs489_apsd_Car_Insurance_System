package miu.edu.car_insurance.dto.vehicle;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.model.Policy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record VehicleResponse(
        Long vehicleId, String make, Long mileage, String vinNumber, LocalDate createdDate, boolean active

) {

}
