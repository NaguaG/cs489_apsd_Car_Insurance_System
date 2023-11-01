package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.vehicle.VehicleRequest;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse2;
import miu.edu.car_insurance.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<VehicleResponse> getAllVehicles();
   // public List<Vehicle> getAllVehicleByCustomerId(Long customerId);
    public VehicleResponse getVehicleById(Long vehicleId);
    public VehicleResponse updateVehicle(Long vehicleId, VehicleRequest vehicleRequest);
    public void deleteVehicleById(Long vehicleId);
    public VehicleResponse addNewVehicle(VehicleRequest vehicleRequest);
}
