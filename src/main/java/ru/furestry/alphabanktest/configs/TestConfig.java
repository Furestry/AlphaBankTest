package ru.furestry.alphabanktest.configs;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import ru.furestry.alphabanktest.controllers.MainController;
import ru.furestry.alphabanktest.services.ExchangeService;
import ru.furestry.alphabanktest.services.GifService;

/**
 * Class for test configuration
 *
 * @author sevler
 */
@Profile("test")
@Configuration
public class TestConfig {

    /**
     * Method for creating mock object for MainController
     *
     * @return mock MainController
     */
    @Bean
    @Primary
    public MainController mainController() {
        return Mockito.mock(MainController.class);
    }

    /**
     * Method for creating mock object for ExchangeService
     *
     * @return mock ExchangeService
     */
    @Bean
    @Primary
    public ExchangeService exchangeService() {
        return Mockito.mock(ExchangeService.class);
    }

    /**
     * Method for creating mock object for GifService
     *
     * @return mock GifService
     */
    @Bean
    @Primary
    public GifService gifService() {
        return Mockito.mock(GifService.class);
    }
}
