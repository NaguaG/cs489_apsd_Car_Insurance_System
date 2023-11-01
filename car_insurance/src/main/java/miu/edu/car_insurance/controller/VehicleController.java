package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.vehicle.VehicleRequest;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse;
import miu.edu.car_insurance.dto.vehicle.VehicleResponse2;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.model.Vehicle;
import miu.edu.car_insurance.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService){
        this.vehicleService =vehicleService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<VehicleResponse>> getAllVehicles(){
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }
    @GetMapping(value = "/get/{vehicleId}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable Long vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));
    }
    @PutMapping(value = "/update/{vehicleId}")
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable Long vehicleId, @RequestBody VehicleRequest vehicleRequest){
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleId, vehicleRequest));
    }
    @DeleteMapping(value = "/delete/{vehicleId}")
    public void deleteVehicle(@PathVariable Long vehicleId){
        vehicleService.deleteVehicleById(vehicleId);
    }
    @PostMapping(value = "/new")
    public ResponseEntity<VehicleResponse> addNewVehicle(@Valid @RequestBody VehicleRequest vehicleRequest){

        return new ResponseEntity<>(vehicleService.addNewVehicle(vehicleRequest), HttpStatus.CREATED);
    }
}
