package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Vehicle;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles();
   // public List<Vehicle> getAllVehicleByCustomerId(Long customerId);
    public Vehicle getVehicleById(Long vehicleId);
    public Vehicle updateVehicle(Long vehicleId, Vehicle vehicle);
    public void deleteVehicleById(Long vehicleId);
    public Vehicle addNewVehicle(Vehicle vehicle);
}
