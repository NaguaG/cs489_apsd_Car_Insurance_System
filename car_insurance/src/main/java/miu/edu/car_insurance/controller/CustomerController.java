package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.service.CustomerService;
import miu.edu.car_insurance.service.imp.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/customers")
public class CustomerController {
    private CustomerService customerService;
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @GetMapping(value = "/list")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }
    @GetMapping(value = "/get/{customerId}")
    public  Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @PutMapping(value = "/update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId, customer);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomerById(customerId);
    }
    @PostMapping(value = "/new")
    public Customer addNewCustomer(Customer customer){
        return customerService.addNewCustomer(customer);
    }
}
