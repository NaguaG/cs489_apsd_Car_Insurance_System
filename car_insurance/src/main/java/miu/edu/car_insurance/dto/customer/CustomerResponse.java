package miu.edu.car_insurance.dto.customer;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Vehicle;
import java.time.LocalDate;
import java.util.List;

public record CustomerResponse(
        Long customerId, String firstName, String lastName, LocalDate dob, String ssn, String gender,
        String email, LocalDate licenseIssuedDate, String licenseIssuedState, LocalDate accountCreatedDate,
        boolean active, List<Vehicle> vehicles, Address address, List<Billing> billings
) {

}
