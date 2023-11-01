package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.model.Billing;

import java.util.List;

public interface BillingService {
    public List<BillingResponse> getAllBillings();
    public BillingResponse getBillingById(Long billingId);
    public BillingResponse updateBilling(Long billingId, BillingRequest billingRequest);
    public void deleteBillingById(Long billingId);
    public BillingResponse addNewBilling(BillingRequest billingRequest);
}
