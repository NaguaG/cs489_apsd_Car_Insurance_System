package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.payment.PaymentRequest;
import miu.edu.car_insurance.dto.payment.PaymentResponse;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<PaymentResponse>> getAllPayments(){

        return ResponseEntity.ok(paymentService.getAllPayments());
    }
    @GetMapping(value = "/get/{paymentId}")
    public  ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long paymentId){
        return ResponseEntity.ok(paymentService.getPaymentById(paymentId));
    }
    @PutMapping(value = "/update/{paymentId}")
    public ResponseEntity<PaymentResponse> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.ok(paymentService.updatePayment(paymentId, paymentRequest));
    }
    @DeleteMapping(value = "/delete/{paymentId}")
    public void deletePayment(@PathVariable Long paymentId){
        paymentService.deletePaymentById(paymentId);
    }
    @PostMapping(value = "/new")
    public ResponseEntity<PaymentResponse> addNewPayment(@Valid @RequestBody PaymentRequest paymentRequest){
        return new ResponseEntity<>(paymentService.addNewPayment(paymentRequest), HttpStatus.CREATED);
    }
}
