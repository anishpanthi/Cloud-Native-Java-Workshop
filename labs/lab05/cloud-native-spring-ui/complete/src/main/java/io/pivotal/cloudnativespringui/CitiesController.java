package io.pivotal.cloudnativespringui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitiesController {

    private CloudNativeSpringUiApplication.CityClient feignCitiesClient;

    public CitiesController(CloudNativeSpringUiApplication.CityClient feignCitiesClient) {
        this.feignCitiesClient = feignCitiesClient;
    }

    @GetMapping("/")
    public String getCities(Model model) {

        model.addAttribute("cities", feignCitiesClient.getCities());
        return "cities"; //thymeleaf template
    }
}
