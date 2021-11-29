/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1_country_city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Khalid Sobh
 */
public class L1_country_city {

    
    public static void main(String[] args) {
        
        CityCSVDAO cityDAO = new CityCSVDAO();
        List<City> citiesList = cityDAO.readCitiesFromCSV("src/main/resources/cities.csv");
        
        CountryCSVDAO countryDAO = new CountryCSVDAO();
        List<Country> countriesList = countryDAO.readCountriesFromCSV("src/main/resources/countries.csv");
        
       Map<String,List<City>> CP = new HashMap<>();
        for(int i = 0; i<citiesList.size(); i++){
            City city = citiesList.get(i);
            
            if(CP.get(city.getCountryId())== null){
                List<City> l = new ArrayList<>();
                l.add(city);
                CP.put(city.getCountryId(), l);
            }
            else{
                CP.get(city.getCountryId()).add(city);
            }
                 
    }
     //lab 1 
    CP.forEach((k, v) -> v.stream().map(City::getPopulation).sorted().collect(Collectors.toList()));
    CP.forEach((k,v)->System.out.println("country code: "+k+"  city List:  "+v));
    
    
    
    //lab 3
    Map<String,Optional<City>>h_pop_c = new HashMap<>();
         CP.forEach((k,v)->{
            Optional<City> y= v.stream().max(Comparator.comparing(City::getPopulation));
            h_pop_c.put(k,y);
                });
    
    Map<String,List<City>> z = citiesList.stream().collect(Collectors.groupingBy(City::getCapital));
    z.forEach((k,v)->
        System.out.println("Capital type:"+k+"  highest population"+
                v.stream().max(Comparator.comparing(City::getPopulation))));

 }
    
    
}