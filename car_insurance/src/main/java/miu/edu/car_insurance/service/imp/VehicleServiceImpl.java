package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.vehicle.VehicleRequest;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse;
import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.repo.VehicleRepository;
import miu.edu.car_insurance.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleResponse> getAllVehicles() {

        return vehicleRepository.findAll().stream()
                .map(v -> new VehicleResponse(v.getVehicleId(), v.getMake(),
                        v.getMileage(), v.getVinNumber(), v.getCreatedDate(), v.isActive())).toList();
    }

//    @Override
//    public List<Vehicle> getAllVehicleByCustomerId(Long customerId) {
//        return vehicleRepository.getAllVehicleByCustomerId(customerId);
//    }

    @Override
    public VehicleResponse getVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElse(null);
        if(vehicle != null){
            return new VehicleResponse(vehicle.getVehicleId(), vehicle.getMake(),
                    vehicle.getMileage(), vehicle.getVinNumber(), vehicle.getCreatedDate(), vehicle.isActive());
        }else {
            return null;
        }
    }

    @Override
    public VehicleResponse updateVehicle(Long vehicleId, VehicleRequest vehicleRequest) {
        Vehicle curr = vehicleRepository.getReferenceById(vehicleId);
        if(curr != null){
            curr.setMake(vehicleRequest.make());
            curr.setMileage(vehicleRequest.mileage());
            curr.setVinNumber(vehicleRequest.vinNumber());
            curr.setCreatedDate(vehicleRequest.createdDate());
            vehicleRepository.save(curr);
            return new VehicleResponse(curr.getVehicleId(), curr.getMake(),
                    curr.getMileage(), curr.getVinNumber(), curr.getCreatedDate(), curr.isActive());
        }else{
            return null;
        }
    }

    @Override
    public void deleteVehicleById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);

    }

    @Override
    public VehicleResponse addNewVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle(vehicleRequest.make(), vehicleRequest.mileage(), vehicleRequest.vinNumber(),
                vehicleRequest.createdDate());
        vehicleRepository.save(vehicle);
        return new VehicleResponse(vehicle.getVehicleId(), vehicle.getMake(),
                vehicle.getMileage(), vehicle.getVinNumber(), vehicle.getCreatedDate(), vehicle.isActive());
    }
}
