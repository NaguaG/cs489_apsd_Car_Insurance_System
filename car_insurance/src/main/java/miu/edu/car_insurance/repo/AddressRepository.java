package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
