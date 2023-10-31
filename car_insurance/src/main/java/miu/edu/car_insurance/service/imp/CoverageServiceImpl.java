package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.model.Coverage;
import miu.edu.car_insurance.repo.CoverageRepository;
import miu.edu.car_insurance.service.CoverageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverageServiceImpl implements CoverageService {
    private CoverageRepository coverageRepository;
    public CoverageServiceImpl(CoverageRepository coverageRepository){
        this.coverageRepository = coverageRepository;
    }

    @Override
    public List<Coverage> getAllCoverages() {
        return coverageRepository.findAll();
    }

    @Override
    public Coverage getCoverageById(Long coverageId) {
        return coverageRepository.findById(coverageId)
                .orElse(null);
    }

    @Override
    public Coverage updateCoverage(Long coverageId, Coverage coverage) {
        return coverageRepository.save(coverage);
    }

    @Override
    public void deleteCoverageById(Long coverageId) {
        coverageRepository.deleteById(coverageId);

    }

    @Override
    public Coverage addNewCoverage(Coverage coverage) {
        return coverageRepository.save(coverage);
    }
}
