package com.example.trialtask.controller;

import com.example.trialtask.entity.Quote;
import com.example.trialtask.entity.User;
import com.example.trialtask.service.QuoteService;
import com.example.trialtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    private UserService userService;
    @Autowired
    private QuoteService quoteService;

    private final static Random RANDOMIZER = new Random();

    @GetMapping("/users")
    public List<User> showAllUsers() {
        List<User> listUsers = userService.getAllUsers();
        return listUsers;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User newUser = userService.createUser(user.getEmail(), user.getPassword(), user.getName());
        return newUser;
    }

    @PostMapping("/quotes")
    public Quote createQuote(@RequestBody Quote quote) {
        User user = userService.getUser(quote.getUser().getId());
        return quoteService.createQuote(quote.getMessage(), user);
    }

    @GetMapping("/quotes")
    public List<Quote> showAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping("/top10quotes")
    public List<Quote> findTop10ByOrderByRatingDesc() {
        return quoteService.findTop10ByOrderByRatingDesc();
    }

    @GetMapping("/flop10quotes")
    public List<Quote> findTop10ByOrderByRatingAsc() {
        return quoteService.findTop10ByOrderByRatingAsc();
    }

    @DeleteMapping("/quotes/{id}")
    public String deleteQuote(@PathVariable int id) {
        quoteService.deleteQuote(id);
        return "quote with id:" + id + " has been deleted";
    }

    @PutMapping("/quotes")
    public Quote updateQuote(@RequestBody Quote quote) {
        quoteService.saveQuote(quote);
        return quote;
    }

    @PutMapping("/quotes/{id}")
    public Quote upvote(@PathVariable int id) {
        Quote quote = quoteService.getQuote(id);
        quote.setRating(quote.getRating() + 1);
        return quoteService.saveQuote(quote);
    }

    @GetMapping("/quotes/{id}")
    public Quote getOneQuote(@PathVariable Long id) {
        return quoteService.getQuote(id);
    }

    @GetMapping("/random")
    public Quote getRandomOne() {
        return getOneQuote(nextLong(1, quoteService.count() + 1));
    }

    private long nextLong(long lowerRange, long upperRange) {
        return (long) (RANDOMIZER.nextDouble() * (upperRange - lowerRange)) + lowerRange;
    }

}
