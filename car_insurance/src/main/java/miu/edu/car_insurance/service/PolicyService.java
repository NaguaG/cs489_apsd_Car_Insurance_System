package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Policy;

import java.util.List;

public interface PolicyService {
    public List<Policy> getAllPolicies();
    public Policy getPolicyById(Long policyId);
    public Policy updatePolicy(Long policyId, Policy policy);
    public void deleteCustomerPolicyByCustomerId(Long customerId);
    public void deletePolicyById(Long policyId);
    public Policy addNewPolicy(Policy policy);
}
