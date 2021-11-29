/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l1_country_city;

/**
 *
 * @author Khalid Sobh
 */
public class Country {
    
    String country;
    String code;

    public Country(String country, String code) {
        this.country = country;
        this.code = code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Country{" + "country=" + country + ", code=" + code + '}';
    }
    
    
    
}
