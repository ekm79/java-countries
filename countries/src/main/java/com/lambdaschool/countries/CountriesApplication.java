package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CountriesApplication {

    public static CountryList countryList;

    public static void main(String[] args) {

        countryList = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
