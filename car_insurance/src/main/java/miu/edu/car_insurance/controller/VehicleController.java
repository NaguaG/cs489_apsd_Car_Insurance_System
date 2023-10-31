package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/vehicles")
public class VehicleController {
    private VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService){
        this.vehicleService =vehicleService;
    }
    @GetMapping(value = "/list")
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
    @GetMapping(value = "/get/{vehicleId}")
    public Vehicle getVehicleById(@PathVariable Long vehicleId){
        return vehicleService.getVehicleById(vehicleId);
    }
    @PutMapping(value = "/update/{vehicleId}")
    public Vehicle updateVehicle(@PathVariable Long vehicleId, @RequestBody Vehicle vehicle){
        return vehicleService.updateVehicle(vehicleId, vehicle);
    }
    @DeleteMapping(value = "/delete/{vehicleId}")
    public void deleteVehicle(@PathVariable Long vehicleId){
        vehicleService.deleteVehicleById(vehicleId);
    }
    @PostMapping(value = "/new")
    public Vehicle addNewVehicle(Vehicle vehicle){
        return vehicleService.addNewVehicle(vehicle);
    }
}
