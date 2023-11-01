package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.payment.PaymentRequest;
import miu.edu.car_insurance.dto.payment.PaymentResponse;
import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.repo.PaymentRepository;
import miu.edu.car_insurance.service.PaymentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    public PaymentServiceImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    @Override
    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll(Sort.by("paymentDate"))
                .stream().map(p -> new PaymentResponse(p.getPaymentId(), p.getPaymentDate(),
                        p.getPaymentAmount(), p.getPaymentType())).toList();
    }

    @Override
    public PaymentResponse getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElse(null);
        if(payment != null){
            return new PaymentResponse(payment.getPaymentId(), payment.getPaymentDate(),
                    payment.getPaymentAmount(), payment.getPaymentType());
        }else {
            return null;
        }
    }

    @Override
    public PaymentResponse updatePayment(Long paymentId, PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.getReferenceById(paymentId);
        if(payment != null){
            payment.setPaymentAmount(paymentRequest.paymentAmount());
            payment.setPaymentType(paymentRequest.paymentType());
            Payment updated = paymentRepository.save(payment);
            return new PaymentResponse(updated.getPaymentId(), updated.getPaymentDate(), updated.getPaymentAmount(), updated.getPaymentType());
        }else{
            return null;
        }
    }

    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public PaymentResponse addNewPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment(paymentRequest.paymentDate(), paymentRequest.paymentAmount(), paymentRequest.paymentType());
        Payment newPayment = paymentRepository.save(payment);
        return new PaymentResponse(newPayment.getPaymentId(), newPayment.getPaymentDate(), newPayment.getPaymentAmount(),
                newPayment.getPaymentType());
    }
}
