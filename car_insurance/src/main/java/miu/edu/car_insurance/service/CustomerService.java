package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.customer.CustomerRequest;
import miu.edu.car_insurance.dto.customer.CustomerResponse;
import miu.edu.car_insurance.dto.customer.CustomerResponse3;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<CustomerResponse> getAllCustomer();
    public CustomerResponse getCustomerById(Long customerId);
    public CustomerResponse updateCustomer(Long customerId, CustomerRequest customerRequest);
    public void deleteCustomerById(Long customerId);
    public CustomerResponse3 addNewCustomer(CustomerRequest customerRequest);
}
