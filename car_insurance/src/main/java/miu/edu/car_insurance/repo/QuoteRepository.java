package miu.edu.car_insurance.repo;

import miu.edu.car_insurance.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
//    List<Quote> findAllByCustomerId(Long customerId);
//    void  deleteAllQuotesByCustomerId(Long customerId);
}
