package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.coverage.CoverageResponse;
import miu.edu.car_insurance.dto.payment.PaymentResponse;
import miu.edu.car_insurance.dto.policy.PolicyRequest;
import miu.edu.car_insurance.dto.policy.PolicyResponse;
import miu.edu.car_insurance.dto.quote.QuoteResponse;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.repo.PolicyRepository;
import miu.edu.car_insurance.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolicyServiceImpl implements PolicyService {
    private final PolicyRepository policyRepository;
    public PolicyServiceImpl(PolicyRepository policyRepository){
        this.policyRepository = policyRepository;
    }
    @Override
    public List<PolicyResponse> getAllPolicies() {

        return policyRepository.findAll()
                .stream().map(p -> new PolicyResponse(p.getPolicyId(), p.getPolicyNumber(), p.getEffectiveDate(),
                        p.getCreatedDate(), p.getExpiredDate(), p.getTotalAmount(), p.isActive(), p.getVehicle(),
                        p.getCoverages().stream().map(c -> new CoverageResponse(c.getCoverageId(), c.getCoverageName(),
                                c.getCoveragePrice())).toList(), p.getQuotes().stream().map(q -> new QuoteResponse(q.getQuoteId(), q.getPrice())).toList(),
                        p.getPayments().stream().map(payment -> new PaymentResponse(payment.getPaymentId(), payment.getPaymentDate(),
                                payment.getPaymentAmount(), payment.getPaymentType())).toList())).toList();
    }

    @Override
    public PolicyResponse getPolicyById(Long policyId) {
        Policy policy = policyRepository.findById(policyId)
                .orElse(null);
        if(policy != null){
            return new PolicyResponse(policy.getPolicyId(), policy.getPolicyNumber(), policy.getEffectiveDate(),
                    policy.getCreatedDate(), policy.getExpiredDate(), policy.getTotalAmount(),
                    policy.isActive(), policy.getVehicle(), policy.getCoverages().stream().map(c -> new CoverageResponse(c.getCoverageId(), c.getCoverageName(),
                    c.getCoveragePrice())).toList(), policy.getQuotes().stream().map(q -> new QuoteResponse(q.getQuoteId(), q.getPrice())).toList(),
                    policy.getPayments().stream().map(payment -> new PaymentResponse(payment.getPaymentId(), payment.getPaymentDate(),
                            payment.getPaymentAmount(), payment.getPaymentType())).toList());

        }else{
            return null;
        }
    }

    @Override
    public PolicyResponse updatePolicy(Long policyId, PolicyRequest policyRequest) {
        Policy policy = policyRepository.getReferenceById(policyId);
        if(policy != null){
            policy.setPolicyNumber(policyRequest.policyNumber());
            policy.setEffectiveDate(policyRequest.effectiveDate());
            policy.setCreatedDate(policyRequest.createdDate());
            policy.setTotalAmount(policyRequest.totalAmount());
            policyRepository.save(policy);
            return new PolicyResponse(policy.getPolicyId(), policy.getPolicyNumber(), policy.getEffectiveDate(),
                    policy.getCreatedDate(), policy.getExpiredDate(), policy.getTotalAmount(), policy.isActive(),
                    policy.getVehicle(), policy.getCoverages().stream().map(c -> new CoverageResponse(c.getCoverageId(), c.getCoverageName(),
                    c.getCoveragePrice())).toList(), policy.getQuotes().stream().map(q -> new QuoteResponse(q.getQuoteId(), q.getPrice())).toList(),
                    policy.getPayments().stream().map(payment -> new PaymentResponse(payment.getPaymentId(), payment.getPaymentDate(),
                            payment.getPaymentAmount(), payment.getPaymentType())).toList());
        }else{
            return null;
        }
    }

    @Override
    public void deleteCustomerPolicyByCustomerId(Long customerId) {
        policyRepository.deleteById(customerId);

    }

    @Override
    public void deletePolicyById(Long policyId) {
        policyRepository.deleteById(policyId);
    }

    @Override
    public PolicyResponse addNewPolicy(PolicyRequest policyRequest) {
        Policy policy = new Policy(policyRequest.policyNumber(), policyRequest.effectiveDate(), policyRequest.createdDate(),
                policyRequest.expiredDate(), policyRequest.totalAmount(), policyRequest.coverages().stream()
                    .map(c -> new Coverage(c.coverageName(), c.coveragePrice())).toList(),
                policyRequest.quotes().stream().map(q -> new Quote(q.price())).toList());
        policyRepository.save(policy);
        return new PolicyResponse(policy.getPolicyId(), policy.getPolicyNumber(), policy.getEffectiveDate(),
                policy.getCreatedDate(), policy.getExpiredDate(), policy.getTotalAmount(), policy.isActive(),
                policy.getVehicle(), policy.getCoverages().stream().map(c -> new CoverageResponse(c.getCoverageId(), c.getCoverageName(),
                c.getCoveragePrice())).toList(), policy.getQuotes().stream().map(q -> new QuoteResponse(q.getQuoteId(), q.getPrice())).toList(),
                policy.getPayments().stream().map(payment -> new PaymentResponse(payment.getPaymentId(), payment.getPaymentDate(),
                        payment.getPaymentAmount(), payment.getPaymentType())).toList());
    }
}
