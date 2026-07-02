package com.cognizant.ormlearn;
import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.service.AttemptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
public class OrmlearnApplication {
    private static final Logger LOGGER =
        LoggerFactory.getLogger(OrmlearnApplication.class);
    private static AttemptService attemptService;
    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(OrmlearnApplication.class, args);
        attemptService = context.getBean(AttemptService.class);
        testGetAttemptDetails();
    }
    private static void testGetAttemptDetails() {
        LOGGER.info("Start");
        Attempt attempt = attemptService.getAttempt(1, 1);
        LOGGER.debug("User: {}", attempt.getUser().getName());
        LOGGER.debug("Date: {}", attempt.getDate());
        attempt.getAttemptQuestionList().forEach(aq -> {
            LOGGER.debug("{}", aq.getQuestion().getText());
            aq.getAttemptOptionList().forEach(ao -> {
                LOGGER.debug(" {})  {}    {}    {}",
                    ao.getOption().getId(),
                    ao.getOption().getText(),
                    ao.getOption().isCorrect()
                        ? aq.getQuestion().getScore() : 0.0,
                    ao.isSelected());
            });
        });
        LOGGER.info("End");
    }
}