package com.cognizant.springlearn.controller;
import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(CountryController.class);

    @GetMapping("/country")
    public Country getCountry() {

        LOGGER.info("Start");

        Country country = new Country("IN", "India");

        LOGGER.info("End");

        return country;
    }
}