package miu.edu.car_insurance.service;

import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.model.Quote;

import java.util.List;

public interface QuoteService {
    public List<Quote> getAllQuote();
    public Quote getQuoteById(Long quoteId);
    //public List<Quote> getAllQuotesByCustomerId(Long customerId);
    public Quote updateQuote(Long quoteId, Quote quote);
   // public void deleteCustomerQuoteByCustomerId(Long customerId);
    public void deleteQuoteById(Long quoteId);
    public Quote addNewQuote(Quote quote);
}
