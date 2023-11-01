package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.coverage.CoverageRequest;
import miu.edu.car_insurance.dto.coverage.CoverageResponse;
import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Coverage;

import java.util.List;

public interface CoverageService {
    public List<CoverageResponse> getAllCoverages();
    public CoverageResponse getCoverageById(Long coverageId);
    public CoverageResponse updateCoverage(Long coverageId, CoverageRequest coverageRequest);
    public void deleteCoverageById(Long coverageId);
    public CoverageResponse addNewCoverage(CoverageRequest coverageRequest);
}
