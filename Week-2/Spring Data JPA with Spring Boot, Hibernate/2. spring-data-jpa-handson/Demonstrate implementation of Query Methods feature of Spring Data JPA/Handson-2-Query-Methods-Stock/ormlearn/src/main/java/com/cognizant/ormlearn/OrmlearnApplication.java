package com.cognizant.ormlearn;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmlearnApplication.class);
    private static StockRepository stockRepository;
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmlearnApplication.class, args);
        stockRepository = context.getBean(StockRepository.class);
        testFBSeptember2019();
        testGoogleGreaterThan1250();
        testTop3HighestVolume();
        testNetflixLowest3();
    }
    private static void testFBSeptember2019() {
        LOGGER.info("=== testFBSeptember2019 Start ===");
        Calendar cal = Calendar.getInstance();
        cal.set(2019, Calendar.SEPTEMBER, 1);
        Date startDate = cal.getTime();
        cal.set(2019, Calendar.SEPTEMBER, 30);
        Date endDate = cal.getTime();

        List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", startDate, endDate);
        LOGGER.debug("FB September 2019: {}", stocks);
        LOGGER.info("=== testFBSeptember2019 End ===");
    }
    private static void testGoogleGreaterThan1250() {
        LOGGER.info("=== testGoogleGreaterThan1250 Start ===");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("Google close > 1250: {}", stocks);
        LOGGER.info("=== testGoogleGreaterThan1250 End ===");
    }
    private static void testTop3HighestVolume() {
        LOGGER.info("=== testTop3HighestVolume Start ===");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 highest volume: {}", stocks);
        LOGGER.info("=== testTop3HighestVolume End ===");
    }
    private static void testNetflixLowest3() {
        LOGGER.info("=== testNetflixLowest3 Start ===");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Netflix lowest 3: {}", stocks);
        LOGGER.info("=== testNetflixLowest3 End ===");
    }
}