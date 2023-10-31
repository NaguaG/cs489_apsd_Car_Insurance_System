package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.repo.QuoteRepository;
import miu.edu.car_insurance.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuoteServiceImpl implements QuoteService {
    private QuoteRepository quoteRepository;
    public QuoteServiceImpl(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }
    @Override
    public List<Quote> getAllQuote() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId)
                .orElse(null);
    }

//    @Override
//    public List<Quote> getAllQuotesByCustomerId(Long customerId) {
//
//        return quoteRepository.findAllByCustomerId(customerId);
//    }

    @Override
    public Quote updateQuote(Long quoteId, Quote quote) {
        return quoteRepository.save(quote);
    }

//    @Override
//    public void deleteCustomerQuoteByCustomerId(Long customerId) {
//        quoteRepository.deleteAllQuotesByCustomerId(customerId);
//    }

    @Override
    public void deleteQuoteById(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Override
    public Quote addNewQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
}
