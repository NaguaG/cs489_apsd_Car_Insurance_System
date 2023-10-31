package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
//    List<Vehicle> getAllVehicleByCustomerId(Long customerId);
}
