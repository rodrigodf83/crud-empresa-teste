package br.com.rodrigo.crudempresateste.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String adress;

    private String number;

    private String complement;

    private String neighborhood;

    private String city;

    private String State;

    private String Country;

    private String zipCode;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getAdress() { return adress; }

    public void setAdress(String adress) { this.adress = adress; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    public String getComplement() { return complement; }

    public void setComplement(String complement) { this.complement = complement; }

    public String getNeighborhood() { return neighborhood; }

    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return State; }

    public void setState(String state) { State = state; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

}
