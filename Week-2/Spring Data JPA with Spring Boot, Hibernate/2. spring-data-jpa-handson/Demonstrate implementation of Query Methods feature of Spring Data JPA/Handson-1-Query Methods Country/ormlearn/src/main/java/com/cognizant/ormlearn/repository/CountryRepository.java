package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Hands-on 1a: Search countries containing text (e.g. 'ou')
    List<Country> findByNameContaining(String text);

    // Hands-on 1b: Same search but sorted ascending by name
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // Hands-on 1c: Countries starting with a given letter (e.g. 'Z')
    List<Country> findByNameStartingWith(String letter);
}