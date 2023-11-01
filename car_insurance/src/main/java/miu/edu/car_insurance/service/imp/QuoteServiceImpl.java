package miu.edu.car_insurance.service.imp;

import miu.edu.car_insurance.dto.quote.QuoteRequest;
import miu.edu.car_insurance.dto.quote.QuoteResponse;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.repo.QuoteRepository;
import miu.edu.car_insurance.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;
    public QuoteServiceImpl(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }
    @Override
    public List<QuoteResponse> getAllQuote() {
        return quoteRepository.findAll()
                .stream().map(q -> new QuoteResponse(q.getQuoteId(), q.getPrice())).toList();
    }

    @Override
    public QuoteResponse getQuoteById(Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElse(null);
        if(quote != null){
            return new QuoteResponse(quote.getQuoteId(), quote.getPrice());
        }else{
            return null;
        }
    }

//    @Override
//    public List<Quote> getAllQuotesByCustomerId(Long customerId) {
//
//        return quoteRepository.findAllByCustomerId(customerId);
//    }

    @Override
    public QuoteResponse updateQuote(Long quoteId, QuoteRequest quoteRequest) {
        Quote curr = quoteRepository.getReferenceById(quoteId);
        if(curr != null){
            curr.setPrice(quoteRequest.price());
            quoteRepository.save(curr);
            return new QuoteResponse(curr.getQuoteId(), curr.getPrice());
        }else{
            return null;
        }
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
    public QuoteResponse addNewQuote(QuoteRequest quoteRequest) {
        Quote quote = new Quote(quoteRequest.price());
        quoteRepository.save(quote);
        return new QuoteResponse(quote.getQuoteId(), quote.getPrice());
    }
}
