package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.policy.PolicyRequest;
import miu.edu.car_insurance.dto.policy.PolicyResponse;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.repo.PolicyRepository;

import java.util.List;

public interface PolicyService {
    public List<PolicyResponse> getAllPolicies();
    public PolicyResponse getPolicyById(Long policyId);
    public PolicyResponse updatePolicy(Long policyId, PolicyRequest policyRequest);
    public void deleteCustomerPolicyByCustomerId(Long customerId);
    public void deletePolicyById(Long policyId);
    public PolicyResponse addNewPolicy(PolicyRequest policyRequest);
}
