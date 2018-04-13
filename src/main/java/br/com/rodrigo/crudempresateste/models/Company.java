package br.com.rodrigo.crudempresateste.models;

import javax.persistence.*;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cnpj;

    private Integer qtdEmployers;

    private String legalResponseName;

    private String LegalResponseCpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Adress adress;

    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    public String getName() { return name; }

    public void setName(String name) {this.name = name; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public Integer getQtdEmployers() { return qtdEmployers; }

    public void setQtdEmployers(Integer qtdEmployers) { this.qtdEmployers = qtdEmployers; }

    public String getLegalResponseName() { return legalResponseName; }

    public void setLegalResponseName(String legalResponseName) { this.legalResponseName = legalResponseName; }

    public String getLegalResponseCpf() { return LegalResponseCpf; }

    public void setLegalResponseCpf(String legalResponseCpf) {  LegalResponseCpf = legalResponseCpf; }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) {  this.adress = adress; }
}
