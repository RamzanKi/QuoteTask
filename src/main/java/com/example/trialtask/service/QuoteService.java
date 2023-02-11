package com.example.trialtask.service;

import com.example.trialtask.entity.Quote;
import com.example.trialtask.entity.User;

import java.util.List;

public interface QuoteService {

    public List<Quote> getAllQuotes();
    public Quote saveQuote(Quote quote);
    public Quote getQuote(long id);
    public void deleteQuote(long id);
    public long count();
    public Quote createQuote(String message, User user);
    public List<Quote> findTop10ByOrderByRatingDesc();
    public List<Quote> findTop10ByOrderByRatingAsc();

}
