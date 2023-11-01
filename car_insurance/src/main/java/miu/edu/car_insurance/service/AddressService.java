package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.address.AddressRequest;
import miu.edu.car_insurance.dto.address.AddressResponse;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.repo.AddressRepository;

import java.util.List;

public interface AddressService {
    public List<AddressResponse> getAllAddresses();
    public AddressResponse getAddressById(Long addressId);
    public AddressResponse updateAddress(Long addressId, AddressRequest addressRequest);
    public void deleteCustomerAddressById(Long customerId);
    public void deleteAddressById(Long addressId);
    public AddressResponse addNewAddress(AddressRequest addressRequest);
}
