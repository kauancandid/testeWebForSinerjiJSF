package br.com.senacrs.TO;

import java.time.LocalDate;
import java.util.List;

public class Person  implements java.io.Serializable {

     private Integer id;
     private String name;
     private LocalDate age;
     private String sex;
     private List<Address> address;

    public Person(int id1, String nome, LocalDate idade, String sexo) {
    }

    public Person(Integer id, String name, LocalDate age, String sex, List<Address> address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
   
}