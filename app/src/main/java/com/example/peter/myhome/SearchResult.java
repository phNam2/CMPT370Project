package com.example.peter.myhome;

/**
 * Created by Administrator on 2017/11/21.
 */

public class SearchResult {
    private String Street;
    private String City;
    private String Country;
    private String PostalCode;
    private int Id;

    public void setStree(String street){
        this.Street = street;
    }

    public String getStreet(){
        return Street;
    }

    public void setCity(String city){
        this.City = city;
    }

    public String getCity(){
        return City;
    }

    public void setCountry(String country){
        this.Country = country;
    }

    public String getCountry(){
        return Country;
    }

    public void setPostalCode(String postalCode){
        this.PostalCode = postalCode;
    }

    public String getPostalCode(){
        return PostalCode;
    }

    public void setId(int id){
        this.Id = id;
    }

    public int getId(){
        return Id;
    }

}
