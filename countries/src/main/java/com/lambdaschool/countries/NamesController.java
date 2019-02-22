package com.lambdaschool.countries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/names")
public class NamesController {

    @RequestMapping(value="/all")
    public CountryList getAllCountries() {
        CountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return CountriesApplication.countryList;
    }


    @RequestMapping(value="/begin")
    public ArrayList<Country> getCountriesByLetter(@RequestParam(value="letter") char l) {
        CountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return CountriesApplication.countryList.findCountries(c -> (c.getName().charAt(0) == l));
    }

    @RequestMapping(value="/size")
    public ArrayList<Country> getCountriesByLength(@RequestParam(value="letters") int i) {
        CountriesApplication.countryList.countryList.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));
        return CountriesApplication.countryList.findCountries(c -> (c.getName().length() == i));
    }
}
