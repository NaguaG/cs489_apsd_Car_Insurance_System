package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.coverage.CoverageRequest;
import miu.edu.car_insurance.dto.coverage.CoverageResponse;
import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.repo.CoverageRepository;
import miu.edu.car_insurance.service.CoverageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverageServiceImpl implements CoverageService {
    private final CoverageRepository coverageRepository;
    public CoverageServiceImpl(CoverageRepository coverageRepository){
        this.coverageRepository = coverageRepository;
    }

    @Override
    public List<CoverageResponse> getAllCoverages() {

        return coverageRepository.findAll()
                .stream().map(
                        c -> new CoverageResponse(
                                c.getCoverageId(),
                                c.getCoverageName(),
                                c.getCoveragePrice()
                        )
                ).toList();
    }

    @Override
    public CoverageResponse getCoverageById(Long coverageId) {
        Coverage coverage = coverageRepository.findById(coverageId)
                .orElse(null);
        return new CoverageResponse(coverage.getCoverageId(), coverage.getCoverageName(), coverage.getCoveragePrice());
    }

    @Override
    public CoverageResponse updateCoverage(Long coverageId, CoverageRequest coverageRequest) {
        Coverage curr = coverageRepository.getReferenceById(coverageId);
        if(curr != null){
            curr.setCoverageName(coverageRequest.coverageName());
            curr.setCoveragePrice(coverageRequest.coveragePrice());
            Coverage updated = coverageRepository.save(curr);
            return new CoverageResponse(updated.getCoverageId(), updated.getCoverageName(), updated.getCoveragePrice());
        }else{
            return null;
        }
    }

    @Override
    public void deleteCoverageById(Long coverageId) {
        coverageRepository.deleteById(coverageId);

    }

    @Override
    public CoverageResponse addNewCoverage(CoverageRequest coverageRequest) {
        Coverage newCoverage = new Coverage(coverageRequest.coverageName(), coverageRequest.coveragePrice());
        coverageRepository.save(newCoverage);
        return new CoverageResponse(newCoverage.getCoverageId(), newCoverage.getCoverageName(), newCoverage.getCoveragePrice());
    }
}
