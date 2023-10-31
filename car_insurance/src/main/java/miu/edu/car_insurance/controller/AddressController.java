package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/adsweb/api/v1/addresses")
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @GetMapping(value = "/list")
    public List<Address> getAllAddress(){
        return addressService.getAllAddresses();
    }
    @GetMapping(value = "/get/{addressId}")
    public  Address getAddressById(@PathVariable Long addressId){
        return addressService.getAddressById(addressId);
    }
    @PutMapping(value = "/update/{addressId}")
    public Address updateAddress(@PathVariable Long addressId, @RequestBody Address address){
        return addressService.updateAddress(addressId, address);
    }
    @DeleteMapping(value = "/delete/{addressId}")
    public void deleteAddress(@PathVariable Long addressId){
        addressService.deleteAddressById(addressId);
    }
    @DeleteMapping(value = "/delete/{customerId}")
    public void deleteAddressByCustomerId(@PathVariable Long customerId){
        addressService.deleteCustomerAddressById(customerId);
    }
    @PostMapping(value = "/new")
    public Address addNewAddress(Address address){
        return addressService.addNewAddress(address);
    }
}
