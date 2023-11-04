package miu.edu.car_insurance.dto.customer;

import miu.edu.car_insurance.dto.address.AddressResponse;
import miu.edu.car_insurance.dto.billing.BillingResponse2;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse2;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Vehicle;
import java.time.LocalDate;
import java.util.List;

public record CustomerResponse(
        Long customerId, String firstName, String lastName, LocalDate dob, String ssn, String gender,
        String email, LocalDate licenseIssuedDate, String licenseIssuedState, LocalDate accountCreatedDate,
        boolean active, List<VehicleResponse2> vehicles, AddressResponse addressResponse, List<BillingResponse2> billings
) {

}
