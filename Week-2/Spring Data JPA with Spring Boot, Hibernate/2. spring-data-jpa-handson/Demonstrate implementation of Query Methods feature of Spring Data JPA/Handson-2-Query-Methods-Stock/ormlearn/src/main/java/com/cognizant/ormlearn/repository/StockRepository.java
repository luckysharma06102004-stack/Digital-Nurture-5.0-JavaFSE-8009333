package com.cognizant.ormlearn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // Query 1: FB stocks in September 2019
    List<Stock> findByCodeAndDateBetween(String code, Date startDate, Date endDate);

    // Query 2: Google stocks where close > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, java.math.BigDecimal close);

    // Query 3: Top 3 highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // Query 4: Netflix lowest 3 close prices
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}