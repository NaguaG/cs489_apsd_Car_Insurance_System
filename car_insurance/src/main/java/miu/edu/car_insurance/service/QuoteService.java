package miu.edu.car_insurance.service;

import miu.edu.car_insurance.dto.quote.QuoteRequest;
import miu.edu.car_insurance.dto.quote.QuoteResponse;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.model.Quote;

import java.util.List;

public interface QuoteService {
    public List<QuoteResponse> getAllQuote();
    public QuoteResponse getQuoteById(Long quoteId);
    //public List<Quote> getAllQuotesByCustomerId(Long customerId);
    public QuoteResponse updateQuote(Long quoteId, QuoteRequest quoteRequest);
   // public void deleteCustomerQuoteByCustomerId(Long customerId);
    public void deleteQuoteById(Long quoteId);
    public QuoteResponse addNewQuote(QuoteRequest quoteRequest);
}
