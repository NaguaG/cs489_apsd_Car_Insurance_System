package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.dto.customer.CustomerResponse2;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.repo.BillingRepository;
import miu.edu.car_insurance.service.BillingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillingServiceImpl implements BillingService {
    private BillingRepository billingRepository;
    public BillingServiceImpl(BillingRepository billingRepository){
        this.billingRepository = billingRepository;
    }
    @Override
    public List<BillingResponse> getAllBillings() {
        return billingRepository.findAll()
                .stream()
                .map(b -> new BillingResponse(
                        b.getBillingId(),
                        b.getBillingMethod(),
                        b.getCardNumber(),
                        b.getExpiryDate(),
                        b.getSecurityCode(),
                        new CustomerResponse2(b.getCustomer().getFirstName(), b.getCustomer().getLastName())
                )).toList();
    }

    @Override
    public BillingResponse getBillingById(Long paymentId) {
        Billing billing = billingRepository.findById(paymentId)
                .orElse(null);
        return new BillingResponse(billing.getBillingId(), billing.getBillingMethod(), billing.getCardNumber(),
                billing.getExpiryDate(), billing.getSecurityCode(),
                new CustomerResponse2(billing.getCustomer().getFirstName(), billing.getCustomer().getLastName()));
    }

    @Override
    public BillingResponse updateBilling(Long billingId, BillingRequest billingRequest) {
        Billing curr = billingRepository.getReferenceById(billingId);
        if(curr != null){
            curr.setBillingMethod(billingRequest.billingMethod());
            curr.setCardNumber(billingRequest.cardNumber());
            curr.setExpiryDate(billingRequest.expiryDate());
            curr.setSecurityCode(billingRequest.securityCode());
            billingRepository.save(curr);
            return new BillingResponse(curr.getBillingId(), curr.getBillingMethod(), curr.getCardNumber(),
                    curr.getExpiryDate(), curr.getSecurityCode(), new CustomerResponse2(curr.getCustomer().getFirstName(), curr.getCustomer().getLastName()));
        }else {
            return null;
        }

    }

    @Override
    public void deleteBillingById(Long paymentId) {
        billingRepository.deleteById(paymentId);

    }

    @Override
    public BillingResponse addNewBilling(BillingRequest billingRequest) {
        Billing newBilling = new Billing(billingRequest.billingMethod(), billingRequest.cardNumber(),
                billingRequest.expiryDate(), billingRequest.securityCode(), billingRequest.customer());
        billingRepository.save(newBilling);

        return new BillingResponse(newBilling.getBillingId(), newBilling.getBillingMethod(), newBilling.getCardNumber(),
                newBilling.getExpiryDate(), newBilling.getSecurityCode(), new CustomerResponse2(newBilling.getCustomer().getFirstName(), newBilling.getCustomer().getLastName()));
    }
}
