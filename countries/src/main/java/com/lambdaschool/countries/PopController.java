package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/population")
public class PopController {

    @RequestMapping(value="/size")
    public ArrayList<Country> getCountriesByPopulation(@RequestParam(value="people") long p) {
        CountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return CountriesApplication.countryList.findCountries(c -> (c.getPopulation() >= p));
    }

    @RequestMapping(value="/min")
    public Country getSmallestCountryByPop() {
        return CountriesApplication.countryList.findCountry(c->c.getMedianAge() == CountriesApplication.countryList.findMinPop());
    }

    @RequestMapping(value="/max")
    public Country getLargestCountryByPop() {
        return CountriesApplication.countryList.findCountry(c->c.getMedianAge() == CountriesApplication.countryList.findMaxPop());
    }
}
