package com.example.trialtask.service;

import com.example.trialtask.entity.Quote;
import com.example.trialtask.entity.User;
import com.example.trialtask.repository.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    QuotesRepository quotesRepository;

    @Override
    public List<Quote> getAllQuotes() {
        return quotesRepository.findAll();
    }

    @Override
    public Quote saveQuote(Quote quote) {
        return quotesRepository.save(quote);
    }

    @Override
    public Quote getQuote(long id) {
        Quote quote = null;
        Optional<Quote> quoteOptional = quotesRepository.findById(id);
        if(quoteOptional.isPresent()) {
            quote = quoteOptional.get();
        }
        return quote;
    }

    @Override
    public void deleteQuote(long id) {
        quotesRepository.deleteById(id);
    }

    @Override
    public long count() {
        return quotesRepository.count();
    }

    public Quote createQuote(String message, User user) {
        Quote quote = new Quote();
        quote.setMessage(message);
        quote.setRating(0L);
        quote.setUser(user);

        return quotesRepository.save(quote);
    }

    @Override
    public List<Quote> findTop10ByOrderByRatingDesc() {
        return quotesRepository.findTop10ByOrderByRatingDesc();
    }

}
