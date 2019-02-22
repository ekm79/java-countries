package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/age")
public class AgeController {

    @RequestMapping(value="/age")
    public ArrayList<Country> getCountriesByAge(@RequestParam(value="age") int a) {
        CountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return CountriesApplication.countryList.findCountries(c -> (c.getMedianAge() >= a));
    }


    @RequestMapping(value="/min")
    public Country getCountryByMinAge() {
        return CountriesApplication.countryList.findCountry(c->c.getMedianAge() == CountriesApplication.countryList.findMinAge());
    }



    @RequestMapping(value="max")
    public Country getCountryByMaxAge() {
        return CountriesApplication.countryList.findCountry(c->c.getMedianAge() == CountriesApplication.countryList.findMaxAge());

    }
}
