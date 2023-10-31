package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
