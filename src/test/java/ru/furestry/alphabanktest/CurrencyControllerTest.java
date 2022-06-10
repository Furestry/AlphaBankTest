package ru.furestry.alphabanktest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.furestry.alphabanktest.configs.TestConfig;
import ru.furestry.alphabanktest.controllers.MainController;
import ru.furestry.alphabanktest.entities.ResponseView;
import ru.furestry.alphabanktest.services.ExchangeService;
import ru.furestry.alphabanktest.services.GifService;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@TestPropertySource(locations = "classpath:application.properties")
class CurrencyControllerTest {
    @Autowired
    private MainController controller;

    @Autowired
    private ExchangeService exchangeService;

    @Autowired
    private GifService gifService;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(exchangeService).isNotNull();
        assertThat(gifService).isNotNull();
    }

    @Test
    public void whenCurrencyBaseIsCorrect_thenRetrievedGif() {
        Mockito.when(exchangeService.getRate("RUB")).thenReturn(new ResponseView("Rich", "256", "256", "https://gifUrl.com"));
        ResponseView view = exchangeService.getRate("RUB");

        assertEquals("Rich", view.getTitle());
        assertEquals("https://gifUrl.com", view.getUrl());
        assertEquals("256", view.getHeight());
        assertEquals("256", view.getWidth());
    }

    @Test
    public void whenQueryIsCorrect_thenRetrievedGif(){
        Mockito.when(gifService.getGif("Rich")).thenReturn(new HashMap<>(){{
            put("url", "https://gifUrl.com");
            put("width", "256");
            put("height", "256");
            put("size", "1024");
        }});

        Map<String, Object> gifMap = gifService.getGif("Rich");

        assertEquals("https://gifUrl.com", gifMap.get("url"));
        assertEquals("256", gifMap.get("width"));
        assertEquals("256", gifMap.get("height"));
    }
}
