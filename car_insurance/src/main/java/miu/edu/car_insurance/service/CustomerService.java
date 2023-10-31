package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(Long customerId);
    public Customer updateCustomer(Long customerId, Customer customer);
    public void deleteCustomerById(Long customerId);
    public Customer addNewCustomer(Customer customer);
}
