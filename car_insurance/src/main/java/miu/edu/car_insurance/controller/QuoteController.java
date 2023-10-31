package miu.edu.car_insurance.controller;

import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.service.QuoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/quotes")
public class QuoteController {
    private QuoteService quoteService;
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }
    @GetMapping(value = "/list")
    public List<Quote> getAllQuotes(){
        return quoteService.getAllQuote();
    }
    @GetMapping(value = "/get/{quoteId}")
    public Quote getQuoteById(@PathVariable Long quoteId){
        return quoteService.getQuoteById(quoteId);
    }
    @PutMapping(value = "/update/{quoteId}")
    public Quote updateQuote(@PathVariable Long quoteId, @RequestBody Quote quote){
        return quoteService.updateQuote(quoteId, quote);
    }
    @DeleteMapping(value = "/delete/{quoteId}")
    public void deleteQuote(@PathVariable Long quoteId){
        quoteService.deleteQuoteById(quoteId);
    }
    @PostMapping(value = "/new")
    public Quote addNewQuote(Quote quote){
        return quoteService.addNewQuote(quote);
    }
}
