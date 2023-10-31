package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.service.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/policies")
public class PolicyController {
    private PolicyService policyService;
    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }
    @GetMapping(value = "/list")
    public List<Policy> getAllPolicy(){
        return policyService.getAllPolicies();
    }
    @GetMapping(value = "/get/{policyId}")
    public Policy getPolicyById(@PathVariable Long policyId){
        return policyService.getPolicyById(policyId);
    }
    @PutMapping(value = "/update/{policyId}")
    public Policy updatePolicy(@PathVariable Long policyId, @RequestBody Policy policy){
        return policyService.updatePolicy(policyId, policy);
    }
    @DeleteMapping(value = "/delete/{policyId}")
    public void deletePolicy(@PathVariable Long policyId){
        policyService.deletePolicyById(policyId);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deletePolicyByCustomerId(@PathVariable Long customerId){
        policyService.deleteCustomerPolicyByCustomerId(customerId);
    }
    @PostMapping(value = "/new")
    public Policy addNewPolicy(Policy policy){
        return policyService.addNewPolicy(policy);
    }
}
