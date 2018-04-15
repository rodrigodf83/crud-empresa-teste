package br.com.rodrigo.crudempresateste.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AdressDTO {

    private Long id;

    @Max(value = 50, message = "O campo logradouro não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo logradouro não pode estar em branco ou nulo.")
    private String adress;

    @Max(value = 50, message = "O campo número não pode ter mais de 8 caracteres.")
    @NotBlank(message = "O campo número não pode estar em branco ou nulo.")
    private String number;

    @Max(value = 50, message = "O campo complemento não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo complemento não pode estar em branco ou nulo.")
    private String complement;

    @Max(value = 50, message = "O campo bairro não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo bairro não pode estar em branco ou nulo.")
    private String neighborhood;

    @Max(value = 50, message = "O campo cidade não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo cidade não pode estar em branco ou nulo.")
    private String city;

    @Max(value = 50, message = "O campo estado não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo estado não pode estar em branco ou nulo.")
    private String State;

    @Max(value = 50, message = "O campo país não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo país não pode estar em branco ou nulo.")
    private String Country;

    @Max(value = 8, message = "O campo Cep deve ter no máximo 8 dígitos.")
    @Min(value = 8, message = "O campo Cep deve ter no mínimo 8 dígitos")
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

    public void setState(String state) {  State = state; }

    public String getCountry() { return Country; }

    public void setCountry(String country) { Country = country; }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
}
