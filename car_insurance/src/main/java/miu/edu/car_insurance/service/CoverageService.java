package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Address;
import miu.edu.car_insurance.model.Coverage;

import java.util.List;

public interface CoverageService {
    public List<Coverage> getAllCoverages();
    public Coverage getCoverageById(Long coverageId);
    public Coverage updateCoverage(Long coverageId, Coverage coverage);
    public void deleteCoverageById(Long coverageId);
    public Coverage addNewCoverage(Coverage coverage);
}
