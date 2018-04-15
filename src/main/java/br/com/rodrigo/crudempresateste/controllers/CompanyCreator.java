package br.com.rodrigo.crudempresateste.controllers;

import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.models.Company;

public class CompanyCreator {
    public static Company companyCreator(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setId(companyDTO.getId());
        company.setName(companyDTO.getName());
        company.setCnpj(companyDTO.getCnpj());
        company.setQtdEmployers(companyDTO.getQtdEmployers());
        company.setLegalResponseName(companyDTO.getLegalResponseName());
        company.setLegalResponseCpf(companyDTO.getLegalResponseCpf());

        return company;

    }
}
