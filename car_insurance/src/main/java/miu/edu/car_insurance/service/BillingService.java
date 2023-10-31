package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Billing;

import java.util.List;

public interface BillingService {
    public List<Billing> getAllBillings();
    public Billing getBillingById(Long billingId);
    public Billing updateBilling(Long billingId, Billing billing);
    public void deleteBillingById(Long billingId);
    public Billing addNewBilling(Billing billing);
}
