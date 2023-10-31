package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
