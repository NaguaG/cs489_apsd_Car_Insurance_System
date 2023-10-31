package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Payment;

import java.util.List;

public interface PaymentService {
    public List<Payment> getAllPayments();
    public Payment getPaymentById(Long paymentId);
    public Payment updatePayment(Long paymentId, Payment payment);
    public void deletePaymentById(Long paymentId);
    public Payment addNewPayment(Payment payment);
}
