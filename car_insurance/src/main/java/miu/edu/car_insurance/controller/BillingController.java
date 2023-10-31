package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.service.BillingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/billing")
public class BillingController {
    private BillingService billingService;
    public BillingController(BillingService billingService){
        this.billingService = billingService;
    }
    @GetMapping(value = "/list")
    public List<Billing> getAllBillingInfo(){
        return billingService.getAllBillings();
    }
    @GetMapping(value = "/get/{billingId}")
    public  Billing getBillingById(@PathVariable Long billingId){
        return billingService.getBillingById(billingId);
    }
    @PutMapping(value = "/update/{billingId}")
    public Billing updateBilling(@PathVariable Long billingId, @RequestBody Billing billing){
        return billingService.updateBilling(billingId, billing);
    }
    @DeleteMapping(value = "/delete/{billingId}")
    public void deleteBilling(@PathVariable Long billingId){
        billingService.deleteBillingById(billingId);
    }
    @PostMapping(value = "/new")
    public Billing addNewBilling(Billing billing){
        return billingService.addNewBilling(billing);
    }
}
