package com.ghmc.biswajeet.ghmcrating;

/**
 * Created by biswajeet on 10/2/17.
 */

public class Dbmodel {
    private String Email;
    private String Phno;
    private String Password;
    private String Locality;
    private Integer Rating;

    public Dbmodel(String Locality,Integer Rating){

        this.Locality=Locality;
        this.Rating=Rating;
    }
    public String getEmail(){
        return  Email;
    }
    public String getPhno(){
        return  Phno;
    }
    public String getPassword(){
        return  Password;
    }
    public void setEmail(String Email){
            this.Email=Email;
    }
    public void setPhno(String Phno){
        this.Phno=Phno;
    }
    public void setPassword(String Password){
        this.Password=Password;
    }
    public void setLocality(String Locality){
        this.Locality=Locality;
    }
    public String getLocality(){return  Locality;}
    public void setRating(Integer Rating){
        this.Rating=Rating;
    }
    public Integer getRating(){return  Rating;}



}
