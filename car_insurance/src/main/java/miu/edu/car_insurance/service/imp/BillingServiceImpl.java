package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.dto.billing.BillingResponse2;
import miu.edu.car_insurance.dto.customer.CustomerResponse2;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.repo.BillingRepository;
import miu.edu.car_insurance.repo.CustomerRepository;
import miu.edu.car_insurance.service.BillingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {
    private final BillingRepository billingRepository;
    private final CustomerRepository customerRepository;
    public BillingServiceImpl(BillingRepository billingRepository, CustomerRepository customerRepository){
        this.billingRepository = billingRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public List<BillingResponse2> getAllBillings() {
        return billingRepository.findAll()
                .stream()
                .map(b -> new BillingResponse2(
                        b.getBillingId(),
                        b.getBillingMethod(),
                        b.getCardNumber(),
                        b.getExpiryDate()
                )).toList();
    }

    @Override
    public BillingResponse2 getBillingById(Long paymentId) {
        Billing billing = billingRepository.findById(paymentId)
                .orElse(null);
        return new BillingResponse2(billing.getBillingId(), billing.getBillingMethod(), billing.getCardNumber(),
                billing.getExpiryDate());
    }

    @Override
    public BillingResponse updateBilling(Long customerId, Long billingId, BillingRequest billingRequest) {

        var customer = customerRepository.findById(customerId).orElse(null);
        if(customer != null){
           Optional<Billing> noLongerBilling = customer.getBillings().stream()
                    .filter(b -> b.getBillingId().equals(billingId))
                    .findFirst();
                if(noLongerBilling.isPresent()){
                    Billing billing = noLongerBilling.get();
                    billing.setBillingMethod(billingRequest.billingMethod());
                    billing.setCardNumber(billingRequest.cardNumber());
                    billing.setExpiryDate(billingRequest.expiryDate());
                    billing.setSecurityCode(billingRequest.securityCode());
                    customerRepository.save(customer);
                    return new BillingResponse(billing.getBillingId(), billing.getBillingMethod(), billing.getCardNumber(),
                            billing.getExpiryDate(), billing.getSecurityCode(),
                            new CustomerResponse2(billing.getCustomer().getFirstName(), billing.getCustomer().getLastName()));
                }else {
                    return null;
                }

            }else {
            return null;
        }

    }

    @Override
    public void deleteBillingById(Long paymentId) {
        billingRepository.deleteById(paymentId);

    }

    @Override
    public BillingResponse addNewBilling(Long customerId, BillingRequest billingRequest) {
        Billing newBilling = new Billing(billingRequest.billingMethod(), billingRequest.cardNumber(),
                billingRequest.expiryDate(), billingRequest.securityCode());
        var currentCustomer = customerRepository.findById(customerId).orElse(null);
        billingRepository.save(newBilling);
        if(currentCustomer != null){
            currentCustomer.addBilling(newBilling);
            customerRepository.save(currentCustomer);
        }else{
            return null;
        }

        return new BillingResponse(newBilling.getBillingId(), newBilling.getBillingMethod(), newBilling.getCardNumber(),
                newBilling.getExpiryDate(), newBilling.getSecurityCode(), new CustomerResponse2(newBilling.getCustomer().getFirstName(), newBilling.getCustomer().getLastName()));
    }
}
