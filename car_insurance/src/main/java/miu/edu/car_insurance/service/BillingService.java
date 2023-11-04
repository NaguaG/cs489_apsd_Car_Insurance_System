package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.dto.billing.BillingResponse2;
import miu.edu.car_insurance.model.Billing;

import java.util.List;

public interface BillingService {
    public List<BillingResponse2> getAllBillings();
    public BillingResponse2 getBillingById(Long billingId);
    public BillingResponse updateBilling(Long customerId, Long billingId, BillingRequest billingRequest);
    public void deleteBillingById(Long billingId);
    public BillingResponse addNewBilling(Long customerId, BillingRequest billingRequest);
}
