package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.payment.PaymentRequest;
import miu.edu.car_insurance.dto.payment.PaymentResponse;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Payment;

import java.util.List;

public interface PaymentService {
    public List<PaymentResponse> getAllPayments();
    public PaymentResponse getPaymentById(Long paymentId);
    public PaymentResponse updatePayment(Long paymentId, PaymentRequest paymentRequest);
    public void deletePaymentById(Long paymentId);
    public PaymentResponse addNewPayment(PaymentRequest paymentRequest);
}
