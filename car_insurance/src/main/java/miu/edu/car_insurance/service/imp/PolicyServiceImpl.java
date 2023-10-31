package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.repo.PolicyRepository;
import miu.edu.car_insurance.service.PolicyService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolicyServiceImpl implements PolicyService {
    private PolicyRepository policyRepository;
    public PolicyServiceImpl(PolicyRepository policyRepository){
        this.policyRepository = policyRepository;
    }
    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public Policy getPolicyById(Long policyId) {
        return policyRepository.findById(policyId)
                .orElse(null);
    }

    @Override
    public Policy updatePolicy(Long policyId, Policy policy) {
        return policyRepository.save(policy);
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
    public Policy addNewPolicy(Policy policy) {
        return policyRepository.save(policy);
    }
}
