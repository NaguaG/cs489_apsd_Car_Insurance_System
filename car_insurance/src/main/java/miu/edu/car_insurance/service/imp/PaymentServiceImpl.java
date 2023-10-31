package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.repo.PaymentRepository;
import miu.edu.car_insurance.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElse(null);
    }

    @Override
    public Payment updatePayment(Long paymentId, Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public Payment addNewPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
