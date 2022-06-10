package ru.furestry.alphabanktest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.furestry.alphabanktest.entities.ResponseView;
import ru.furestry.alphabanktest.services.ExchangeService;
import ru.furestry.alphabanktest.services.GifService;

/**
 * A class for processing html requests
 *
 * @author Sevler
 */
@Controller
public class MainController {

    private GifService gifService;
    private ExchangeService exchangeService;

    /**
     * Class constructor
     *
     * @param gifService the gifService to set
     * @param exchangeService the exchangeService to set
     */
    public MainController(GifService gifService, ExchangeService exchangeService) {
        this.gifService = gifService;
        this.exchangeService = exchangeService;
    }

    /**
     * Method for processing html request and outputting a response with a gif
     *
     * @param currency the currency to set
     * @param model the model to set
     * @return html page with the gif
     */
    @GetMapping("/")
    public String index(@RequestParam String currency, Model model) {
        ResponseView view = exchangeService.getRate(currency);

        model.addAttribute("view", view);

        return "index";
    }
}
