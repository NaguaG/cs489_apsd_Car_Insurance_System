package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.coverage.CoverageRequest;
import miu.edu.car_insurance.dto.coverage.CoverageResponse;
import miu.edu.car_insurance.model.Billing;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.service.CoverageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/coverages")
public class CoverageController {
    private final CoverageService coverageService;
    public CoverageController(CoverageService coverageService){
        this.coverageService = coverageService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<CoverageResponse>> getAllCoverages(){

        return ResponseEntity.ok(coverageService.getAllCoverages());
    }
    @GetMapping(value = "/get/{coverageId}")
    public  ResponseEntity<CoverageResponse> getCoverageById(@PathVariable Long coverageId){
        return ResponseEntity.ok(coverageService.getCoverageById(coverageId));
    }
    @PutMapping(value = "/update/{coverageId}")
    public ResponseEntity<CoverageResponse> updateCoverage(@PathVariable Long coverageId, @RequestBody CoverageRequest coverageRequest){
        return ResponseEntity.ok(coverageService.updateCoverage(coverageId, coverageRequest));
    }
    @DeleteMapping(value = "/delete/{coverageId}")
    public void deleteCoverage(@PathVariable Long coverageId){
        coverageService.deleteCoverageById(coverageId);
    }
    @PostMapping(value = "/new")
    public ResponseEntity<CoverageResponse> addNewCoverage(@Valid @RequestBody CoverageRequest coverageRequest){
        return new ResponseEntity<>(coverageService.addNewCoverage(coverageRequest), HttpStatus.CREATED);
    }
}
