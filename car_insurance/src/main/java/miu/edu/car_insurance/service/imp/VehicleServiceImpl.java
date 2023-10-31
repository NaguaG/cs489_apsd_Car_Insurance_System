package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.repo.VehicleRepository;
import miu.edu.car_insurance.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;
    public VehicleServiceImpl(VehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

//    @Override
//    public List<Vehicle> getAllVehicleByCustomerId(Long customerId) {
//        return vehicleRepository.getAllVehicleByCustomerId(customerId);
//    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId)
                .orElse(null);
    }

    @Override
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteVehicleById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);

    }

    @Override
    public Vehicle addNewVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
