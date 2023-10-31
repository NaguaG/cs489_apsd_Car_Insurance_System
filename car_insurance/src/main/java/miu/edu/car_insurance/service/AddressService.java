package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddresses();
    public Address getAddressById(Long addressId);
    public Address updateAddress(Long addressId, Address address);
    public void deleteCustomerAddressById(Long customerId);
    public void deleteAddressById(Long addressId);
    public Address addNewAddress(Address address);
}
