package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.policy.PolicyRequest;
import miu.edu.car_insurance.dto.policy.PolicyResponse;
import miu.edu.car_insurance.model.Payment;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/policies")
public class PolicyController {
    private final PolicyService policyService;
    public PolicyController(PolicyService policyService){
        this.policyService = policyService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<PolicyResponse>> getAllPolicy(){
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
    @GetMapping(value = "/get/{policyId}")
    public ResponseEntity<PolicyResponse> getPolicyById(@PathVariable Long policyId){
        return ResponseEntity.ok(policyService.getPolicyById(policyId));
    }
    @PutMapping(value = "/update/{policyId}")
    public ResponseEntity<PolicyResponse> updatePolicy(@PathVariable Long policyId, @RequestBody PolicyRequest policyRequest){
        return ResponseEntity.ok(policyService.updatePolicy(policyId, policyRequest));
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
    public ResponseEntity<PolicyResponse> addNewPolicy(@Valid @RequestBody PolicyRequest policyRequest){
        return new ResponseEntity<>(policyService.addNewPolicy(policyRequest), HttpStatus.CREATED);
    }
}
