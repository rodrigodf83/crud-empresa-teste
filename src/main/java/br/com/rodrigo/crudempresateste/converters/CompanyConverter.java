package br.com.rodrigo.crudempresateste.converters;

import br.com.rodrigo.crudempresateste.dtos.AdressDTO;
import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.models.Adress;
import br.com.rodrigo.crudempresateste.models.Company;

public class CompanyConverter {
    public static Company companyConverter(CompanyDTO companyDTO, Company company) {

        if (company == null)
            company = new Company();

        company.setName(companyDTO.getName());
        company.setCnpj(companyDTO.getCnpj());
        company.setQtdEmployers(companyDTO.getQtdEmployers());
        company.setLegalResponseName(companyDTO.getLegalResponseName());
        company.setLegalResponseCpf(companyDTO.getLegalResponseCpf());

        Adress adress = new Adress();

        adress.setId(companyDTO.getAdressDTO().getId());
        adress.setAdress(companyDTO.getAdressDTO().getAdress());
        adress.setNumber(companyDTO.getAdressDTO().getNumber());
        adress.setComplement(companyDTO.getAdressDTO().getComplement());
        adress.setNeighborhood(companyDTO.getAdressDTO().getNeighborhood());
        adress.setCity(companyDTO.getAdressDTO().getCity());
        adress.setState(companyDTO.getAdressDTO().getState());
        adress.setCountry(companyDTO.getAdressDTO().getCountry());
        adress.setZipCode(companyDTO.getAdressDTO().getZipCode());

        company.setAdress(adress);
        return company;
    }

    public static CompanyDTO companyDTOConverter(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setName(company.getName());
        companyDTO.setCnpj(company.getCnpj());
        companyDTO.setQtdEmployers(company.getQtdEmployers());
        companyDTO.setLegalResponseName(company.getLegalResponseName());
        companyDTO.setLegalResponseCpf(company.getLegalResponseCpf());

        AdressDTO adressDTO = new AdressDTO();

        adressDTO.setId(company.getAdress().getId());
        adressDTO.setAdress(company.getAdress().getAdress());
        adressDTO.setNumber(company.getAdress().getNumber());
        adressDTO.setComplement(company.getAdress().getComplement());
        adressDTO.setNeighborhood(company.getAdress().getNeighborhood());
        adressDTO.setCity(company.getAdress().getCity());
        adressDTO.setState(company.getAdress().getState());
        adressDTO.setCountry(company.getAdress().getCountry());
        adressDTO.setZipCode(company.getAdress().getZipCode());

        companyDTO.setAdressDTO(adressDTO);
        return companyDTO;
    }

}
