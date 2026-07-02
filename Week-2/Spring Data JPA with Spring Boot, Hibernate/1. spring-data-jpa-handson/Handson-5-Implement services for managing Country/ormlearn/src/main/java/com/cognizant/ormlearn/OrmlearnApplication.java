package com.cognizant.ormlearn;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);
    private static CountryService countryService;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        LOGGER.info("Inside main");
        try {
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testFindCountriesByPartialName();
            testDeleteCountry();
        } catch (CountryNotFoundException e) {
            LOGGER.error("Error: {}", e.getMessage());
        }
    }
    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("=== testFindCountryByCode Start ===");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Country found: {}", country);
        LOGGER.info("=== testFindCountryByCode End ===");
    }

    private static void testAddCountry() {
        LOGGER.info("=== testAddCountry Start ===");
        Country newCountry = new Country("XX", "Test Country");
        countryService.addCountry(newCountry);
        LOGGER.debug("Country added: {}", newCountry);
        LOGGER.info("=== testAddCountry End ===");
    }

    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("=== testUpdateCountry Start ===");
        countryService.updateCountry("XX", "Updated Test Country");
        Country updated = countryService.findCountryByCode("XX");
        LOGGER.debug("Country after update: {}", updated);
        LOGGER.info("=== testUpdateCountry End ===");
    }

    private static void testFindCountriesByPartialName() {
        LOGGER.info("=== testFindCountriesByPartialName Start ===");
        List<Country> countries = countryService.findCountriesByPartialName("Republic");
        LOGGER.debug("Countries matching 'Republic': {}", countries);
        LOGGER.info("=== testFindCountriesByPartialName End ===");
    }

    private static void testDeleteCountry() {
        LOGGER.info("=== testDeleteCountry Start ===");
        countryService.deleteCountry("XX");
        LOGGER.info("=== testDeleteCountry End ===");
    }
}