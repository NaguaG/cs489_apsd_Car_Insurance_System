package miu.edu.car_insurance.repo;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import miu.edu.car_insurance.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
