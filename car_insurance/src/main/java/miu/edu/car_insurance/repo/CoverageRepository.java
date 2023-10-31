package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Coverage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageRepository extends JpaRepository<Coverage, Long> {
}
