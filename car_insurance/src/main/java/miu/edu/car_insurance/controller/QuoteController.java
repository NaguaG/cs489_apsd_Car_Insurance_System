package miu.edu.car_insurance.controller;

import jakarta.validation.Valid;
import miu.edu.car_insurance.dto.quote.QuoteRequest;
import miu.edu.car_insurance.dto.quote.QuoteResponse;
import miu.edu.car_insurance.model.Policy;
import miu.edu.car_insurance.model.Quote;
import miu.edu.car_insurance.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/quotes")
public class QuoteController {
    private final QuoteService quoteService;
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }
    @GetMapping(value = "/list")
    public ResponseEntity<List<QuoteResponse>> getAllQuotes(){

        return ResponseEntity.ok(quoteService.getAllQuote());
    }
    @GetMapping(value = "/get/{quoteId}")
    public ResponseEntity<QuoteResponse> getQuoteById(@PathVariable Long quoteId){
        return ResponseEntity.ok(quoteService.getQuoteById(quoteId));
    }
    @PutMapping(value = "/update/{quoteId}")
    public ResponseEntity<QuoteResponse> updateQuote(@PathVariable Long quoteId, @RequestBody QuoteRequest quoteRequest){
        return ResponseEntity.ok(quoteService.updateQuote(quoteId, quoteRequest));
    }
    @DeleteMapping(value = "/delete/{quoteId}")
    public void deleteQuote(@PathVariable Long quoteId){
        quoteService.deleteQuoteById(quoteId);
    }
    @PostMapping(value = "/new")
    public ResponseEntity<QuoteResponse> addNewQuote(@Valid @RequestBody QuoteRequest quoteRequest){

        return new ResponseEntity<>(quoteService.addNewQuote(quoteRequest), HttpStatus.CREATED);
    }
}
