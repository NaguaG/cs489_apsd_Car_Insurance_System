package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.customer.CustomerRequest;
import miu.edu.car_insurance.dto.customer.CustomerResponse;
import miu.edu.car_insurance.dto.customer.CustomerResponse2;
import miu.edu.car_insurance.dto.customer.CustomerResponse3;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.service.CustomerService;
import miu.edu.car_insurance.service.imp.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){

        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping(value = "/get/{customerId}")
    public  ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
    @PutMapping(value = "/update/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerRequest customerRequest){
        return ResponseEntity.ok(customerService.updateCustomer(customerId, customerRequest));
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }
    @PostMapping(value = "/new")
    public ResponseEntity<CustomerResponse3> addNewCustomer(@Valid @RequestBody CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.addNewCustomer(customerRequest), HttpStatus.CREATED);
    }
}
