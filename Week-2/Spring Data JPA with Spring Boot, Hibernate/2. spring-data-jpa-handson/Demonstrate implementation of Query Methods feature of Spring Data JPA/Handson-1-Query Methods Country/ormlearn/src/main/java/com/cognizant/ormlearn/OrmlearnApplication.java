package com.cognizant.ormlearn;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);
    private static CountryRepository countryRepository;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        countryRepository = context.getBean(CountryRepository.class);

        testSearchContaining();
        testSearchContainingOrdered();
        testSearchStartingWith();
    }
    // Hands-on 1a: Find countries containing 'ou'
    private static void testSearchContaining() {
        LOGGER.info("=== testSearchContaining Start ===");
        List<Country> countries = countryRepository.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("=== testSearchContaining End ===");
    }
    // Hands-on 1b: Find countries containing 'ou' sorted ascending
    private static void testSearchContainingOrdered() {
        LOGGER.info("=== testSearchContainingOrdered Start ===");
        List<Country> countries = countryRepository.findByNameContainingOrderByNameAsc("ou");
        LOGGER.debug("Countries containing 'ou' ordered: {}", countries);
        LOGGER.info("=== testSearchContainingOrdered End ===");
    }
    // Hands-on 1c: Find countries starting with 'Z'
    private static void testSearchStartingWith() {
        LOGGER.info("=== testSearchStartingWith Start ===");
        List<Country> countries = countryRepository.findByNameStartingWith("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("=== testSearchStartingWith End ===");
    }
}