package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.address.AddressRequest;
import miu.edu.car_insurance.dto.address.AddressResponse;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.repo.AddressRepository;
import miu.edu.car_insurance.service.AddressService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    @Override
    public List<AddressResponse> getAllAddresses() {

        return addressRepository.findAll(Sort.by("state"))
                .stream()
                .map(a -> new AddressResponse(
                        a.getAddressId(),
                        a.getStreet(),
                        a.getCity(),
                        a.getState(),
                        a.getZipcode()
                )).toList();
    }

    @Override
    public AddressResponse getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElse(null);
        return new AddressResponse(address.getAddressId(), address.getStreet(), address.getCity(), address.getState(), address.getZipcode());
    }

    @Override
    public AddressResponse updateAddress(Long addressId, AddressRequest addressRequest) {
        Address curr = addressRepository.getReferenceById(addressId);
        if(curr != null){
            curr.setStreet(addressRequest.street());
            curr.setCity(addressRequest.city());
            curr.setState(addressRequest.state());
            curr.setZipcode(addressRequest.zipcode());
            var updated = addressRepository.save(curr);
            return new AddressResponse(updated.getAddressId(), updated.getStreet(), updated.getCity(), updated.getState(), updated.getZipcode());
        }else{
            Address newAddress = new Address(addressRequest.street(), addressRequest.city(), addressRequest.state(), addressRequest.zipcode());
            addressRepository.save(newAddress);
            return new AddressResponse(newAddress.getAddressId(), newAddress.getStreet(), newAddress.getCity(), newAddress.getState(), newAddress.getZipcode());
        }
   }

    @Override
    public void deleteCustomerAddressById(@PathVariable("customerId") Long customerId) {
        addressRepository.deleteById(customerId);
    }

    @Override
    public void deleteAddressById(@PathVariable("id") Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public AddressResponse addNewAddress(AddressRequest addressRequest) {
        Address newAddress = new Address(addressRequest.street(), addressRequest.city(), addressRequest.state(), addressRequest.zipcode());
        addressRepository.save(newAddress);
        return new AddressResponse(newAddress.getAddressId(), newAddress.getStreet(), newAddress.getCity(), newAddress.getState(), newAddress.getZipcode());

    }
}
