package miu.edu.car_insurance.service.imp;

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
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    @Override
    public Billing getBillingById(Long paymentId) {
        return billingRepository.findById(paymentId)
                .orElse(null);
    }

    @Override
    public Billing updateBilling(Long paymentId, Billing billing) {
        return billingRepository.save(billing);
    }

    @Override
    public void deleteBillingById(Long paymentId) {
        billingRepository.deleteById(paymentId);

    }

    @Override
    public Billing addNewBilling(Billing billing) {
        return billingRepository.save(billing);
    }
}
