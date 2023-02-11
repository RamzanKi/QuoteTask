package com.example.trialtask.repository;

import com.example.trialtask.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote, Long> {
    public List<Quote> findTop10ByOrderByRatingDesc();
    public List<Quote> findTop10ByOrderByRatingAsc();
}
