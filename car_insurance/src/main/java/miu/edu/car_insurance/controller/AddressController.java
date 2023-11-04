package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.address.AddressRequest;
import miu.edu.car_insurance.dto.address.AddressResponse;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.repo.AddressRepository;
import miu.edu.car_insurance.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/adsweb/api/v1/addresses")
public class AddressController {
    private final AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<AddressResponse>> getAllAddress(){

        return ResponseEntity.ok(addressService.getAllAddresses());
    }
    @GetMapping(value = "/get/{addressId}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.getAddressById(addressId));
    }
    @PutMapping(value = "/update/{addressId}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long addressId, @RequestBody AddressRequest addressRequest){
        return ResponseEntity.ok(addressService.updateAddress(addressId, addressRequest));
    }
    @DeleteMapping(value = "/delete/{addressId}")
    public void deleteAddress(@PathVariable Long addressId){

        addressService.deleteAddressById(addressId);
    }
//    @DeleteMapping(value = "/delete/{customerId}")
//    public void deleteAddressByCustomerId(@PathVariable("customerId") Long customerId){
//        addressService.deleteCustomerAddressById(customerId);
//    }
    @PostMapping(value = "/new")
    public ResponseEntity<AddressResponse> addNewAddress(@Valid @RequestBody AddressRequest addressRequest){
        return new ResponseEntity<>(addressService.addNewAddress(addressRequest), HttpStatus.CREATED);
    }
}
