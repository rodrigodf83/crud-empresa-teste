package br.com.rodrigo.crudempresateste.dtos;

import br.com.rodrigo.crudempresateste.models.Adress;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CompanyDTO {

    private Long id;

    @Max(value = 50, message = "O campo nome não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo nome não pode estar em branco ou nulo.")
    private String name;

    @CNPJ(message = "O CNPJ informado não é válido.")
    private String cnpj;

    @NotBlank(message = "A quantidade de funcionários não pode estar em branco ou nula.")
    private Integer qtdEmployers;

    @Max(value = 50, message = "O campo nome do responsável legal não pode ter mais de 50 caracteres.")
    @NotBlank(message = "O campo nome do responsável legal não pode estar em branco ou nulo.")
    private String legalResponseName;

    @CPF(message = "O CPF informado não é válido.")
    private String LegalResponseCpf;

    private Adress adress;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCnpj() { return cnpj; }

    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public Integer getQtdEmployers() { return qtdEmployers; }

    public void setQtdEmployers(Integer qtdEmployers) { this.qtdEmployers = qtdEmployers; }

    public String getLegalResponseName() { return legalResponseName; }

    public void setLegalResponseName(String legalResponseName) { this.legalResponseName = legalResponseName; }

    public String getLegalResponseCpf() { return LegalResponseCpf; }

    public void setLegalResponseCpf(String legalResponseCpf) { LegalResponseCpf = legalResponseCpf; }

    public Adress getAdress() { return adress; }

    public void setAdress(Adress adress) { this.adress = adress; }
}
