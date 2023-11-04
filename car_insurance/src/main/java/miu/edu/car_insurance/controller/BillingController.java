package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.dto.billing.BillingResponse2;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.service.BillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/billing")
public class BillingController {
    private final BillingService billingService;
    public BillingController(BillingService billingService){
        this.billingService = billingService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<BillingResponse2>> getAllBillingInfo(){

        return ResponseEntity.ok( billingService.getAllBillings());
    }
    @GetMapping(value = "/get/{billingId}")
    public  ResponseEntity<BillingResponse2> getBillingById(@PathVariable Long billingId){
        return ResponseEntity.ok(billingService.getBillingById(billingId));
    }
    @PutMapping(value = "/update/{customerId}/{billingId}")
    public ResponseEntity<BillingResponse> updateBilling(@PathVariable Long customerId, @PathVariable Long billingId, @RequestBody BillingRequest billingRequest){
        return ResponseEntity.ok(billingService.updateBilling(customerId, billingId, billingRequest));
    }
    @DeleteMapping(value = "/delete/{billingId}")
    public void deleteBilling(@PathVariable Long billingId){
        billingService.deleteBillingById(billingId);
    }
    @PostMapping(value = "/new/{customerId}")
    public ResponseEntity<BillingResponse> addNewBilling(@PathVariable Long customerId, @Valid @RequestBody BillingRequest billingRequest){
        return new ResponseEntity<>(billingService.addNewBilling(customerId, billingRequest), HttpStatus.CREATED);
    }
}
