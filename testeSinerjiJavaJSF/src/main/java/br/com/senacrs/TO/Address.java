package br.com.senacrs.TO;

public class Address  implements java.io.Serializable {

     private Integer id;
     private String state;
     private String city;
     private String publicPlace;
     private int num;
     private int zipCode;

    public Address() {
    }

    public Address(Integer id, String state, String city, String publicPlace, int num, int zipCode) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.publicPlace = publicPlace;
        this.num = num;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}