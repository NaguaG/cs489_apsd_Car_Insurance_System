package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
