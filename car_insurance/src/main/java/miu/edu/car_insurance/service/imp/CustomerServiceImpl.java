package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.address.AddressResponse;
import miu.edu.car_insurance.dto.billing.BillingRequest;
import miu.edu.car_insurance.dto.billing.BillingRequest2;
import miu.edu.car_insurance.dto.billing.BillingResponse;
import miu.edu.car_insurance.dto.billing.BillingResponse2;
import miu.edu.car_insurance.dto.customer.CustomerRequest;
import miu.edu.car_insurance.dto.customer.CustomerResponse;
import miu.edu.car_insurance.dto.customer.CustomerResponse3;
import miu.edu.car_insurance.dto.vehicle.VehicleRequest;
import miu.edu.car_insurance.dto.vehicle.VehicleRequest2;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse2;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Customer;
import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.repo.AddressRepository;
import miu.edu.car_insurance.repo.BillingRepository;
import miu.edu.car_insurance.repo.CustomerRepository;
import miu.edu.car_insurance.repo.VehicleRepository;
import miu.edu.car_insurance.service.AddressService;
import miu.edu.car_insurance.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final BillingRepository billingRepository;
    private final VehicleRepository vehicleRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository,
                               BillingRepository billingRepository, VehicleRepository vehicleRepository){
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.billingRepository = billingRepository;
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll()
                .stream().map(c -> new CustomerResponse(
                        c.getCustomerId(),
                        c.getFirstName(),
                        c.getLastName(),
                        c.getDob(),
                        c.getSsn(),
                        c.getGender(),
                        c.getEmail(),
                        c.getLicenseIssuedDate(),
                        c.getLicenseIssuedState(),
                        c.getAccountCreatedDate(),
                        c.isActive(),
                        c.getVehicles()
                                .stream().map(v -> new VehicleResponse2(v.getVehicleId(), v.getMake())).toList(),
                        new AddressResponse(c.getAddress().getAddressId(), c.getAddress().getStreet(), c.getAddress().getCity(),
                                c.getAddress().getState(), c.getAddress().getZipcode()),
                        c.getBillings()
                                .stream().map(b -> new BillingResponse2(b.getBillingId(), b.getBillingMethod(),
                                        b.getCardNumber(), b.getExpiryDate())).toList()
                )).toList();
    }

    @Override
    public CustomerResponse getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElse(null);
        return new CustomerResponse(customer.getCustomerId(), customer.getFirstName(), customer.getLastName(),
                customer.getDob(), customer.getSsn(), customer.getGender(), customer.getEmail(), customer.getLicenseIssuedDate(),
                customer.getLicenseIssuedState(), customer.getAccountCreatedDate(), customer.isActive(),
                customer.getVehicles().stream().map(v -> new VehicleResponse2(v.getVehicleId(), v.getMake())).toList(),
                new AddressResponse(customer.getAddress().getAddressId(), customer.getAddress().getStreet(), customer.getAddress().getCity(),
                        customer.getAddress().getState(), customer.getAddress().getZipcode()),
                customer.getBillings().stream().map(b -> new BillingResponse2(b.getBillingId(), b.getBillingMethod(),
                b.getCardNumber(), b.getExpiryDate())).toList());
    }

    @Override
    public CustomerResponse updateCustomer(Long customerId, CustomerRequest customerRequest) {
        Customer curr = customerRepository.getReferenceById(customerId);
        if(curr != null){
            curr.setFirstName(customerRequest.firstName());
            curr.setLastName(customerRequest.lastName());
            curr.setDob(customerRequest.dob());
            curr.setSsn(customerRequest.ssn());
            curr.setGender(customerRequest.gender());
            curr.setEmail(customerRequest.email());
            curr.setLicenseIssuedDate(customerRequest.licenseIssuedDate());
            curr.setLicenseIssuedState(customerRequest.licenseIssuedState());
            curr.setAccountCreatedDate(customerRequest.accountCreatedDate());
            curr.setActive(customerRequest.active());
//            for(VehicleRequest2 newV: customerRequest.vehicles()){
//                Long id = newV.vehicleId();
//                for(Vehicle v: curr.getVehicles()){
//                    if( v.getVehicleId() == id){
//                        v.setMake(newV.make());
//                        v.setMileage(newV.mileage());
//                        v.setVinNumber(newV.vinNumber());
//                        v.setPolicy(newV.policy());
//                    }
//                }
//            }

//            vehicleRepository.saveAll(curr.getVehicles());


            //Could be call from addressService
            Address updatedAddress = new Address(customerRequest.address().street(), customerRequest.address().city(), customerRequest.address().state(),
                    customerRequest.address().zipcode());
//            addressRepository.save(updatedAddress);
            curr.setAddress(updatedAddress);

//            for(BillingRequest2 newB: customerRequest.billing()){
//                Long id = newB.billingId();
//                for(Billing b: curr.getBillings()){
//                    if(b.getBillingId() == id){
//                        b.setBillingMethod(newB.billingMethod());
//                        b.setCardNumber(newB.cardNumber());
//                        b.setExpiryDate(newB.expiryDate());
//                        b.setSecurityCode(newB.securityCode());
//                    }
//                }
//            }
 //           billingRepository.saveAll(curr.getBillings());

            Customer updated = customerRepository.save(curr);
            return new CustomerResponse(updated.getCustomerId(), updated.getFirstName(), updated.getLastName(),
                    updated.getDob(), updated.getSsn(), updated.getGender(), updated.getEmail(), updated.getLicenseIssuedDate(),
                    updated.getLicenseIssuedState(), updated.getAccountCreatedDate(), updated.isActive(),
                    updated.getVehicles().stream().map(v -> new VehicleResponse2(v.getVehicleId(), v.getMake())).toList(),
                    new AddressResponse(updated.getAddress().getAddressId(), updated.getAddress().getStreet(), updated.getAddress().getCity(),
                            updated.getAddress().getState(), updated.getAddress().getZipcode()), updated.getBillings().stream()
                    .map(b -> new BillingResponse2(b.getBillingId(), b.getBillingMethod(), b.getCardNumber(), b.getExpiryDate())).toList());
        }else{
            return null;
        }
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        customerRepository.deleteById(customerId);

    }

    @Override
    public CustomerResponse3 addNewCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer(customerRequest.firstName(), customerRequest.lastName(), customerRequest.dob(),
                customerRequest.ssn(), customerRequest.gender(), customerRequest.email(), customerRequest.licenseIssuedDate(),
                customerRequest.licenseIssuedState(), customerRequest.accountCreatedDate(), customerRequest.active(), new Address(customerRequest.address().street(), customerRequest.address().city(),
                customerRequest.address().state(), customerRequest.address().zipcode()));
        Customer updated = customerRepository.save(customer);
        return new CustomerResponse3(updated.getCustomerId(), updated.getFirstName(), updated.getLastName(), updated.getDob(),
                updated.getSsn(), updated.getGender(), updated.getEmail(), updated.getLicenseIssuedDate(), updated.getLicenseIssuedState(), updated.getAccountCreatedDate(),
                updated.isActive(), new AddressResponse(updated.getAddress().getAddressId(), updated.getAddress().getStreet(),
                updated.getAddress().getCity(), updated.getAddress().getState(), updated.getAddress().getZipcode()));
    }
}
