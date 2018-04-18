package br.com.rodrigo.crudempresateste.services;

import br.com.rodrigo.crudempresateste.converters.CompanyConverter;
import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.exceptions.ErrorExecutionException;
import br.com.rodrigo.crudempresateste.exceptions.InvalidDataException;
import br.com.rodrigo.crudempresateste.models.Company;
import br.com.rodrigo.crudempresateste.repositories.CompanyRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company) {
        try {
            Company companyAlreadySaved = this.companyRepository.findByCnpj(company.getCnpj());
            if (companyAlreadySaved != null)
                throw new InvalidDataException("Já existe uma empresa cadastrada com o CNPJ informado!");

            return this.companyRepository.saveAndFlush(company);
        } catch (ErrorExecutionException e) {
            throw new ErrorExecutionException("Ocorreu um erro ao salvar a empresa!");
        }
    }

    public Company update(CompanyDTO companyDTO) {
        try {
            Company company = this.findOneByCnpj(companyDTO.getCnpj());
            company = CompanyConverter.companyConverter(companyDTO, company);
            return this.companyRepository.saveAndFlush(company);
        } catch (ErrorExecutionException e) {
            throw  new ErrorExecutionException("Ocorreu um erro ao atualizar a empresa.");
        }
    }

    public Company findOneByCnpj(String cnpj) {

        Company company = this.companyRepository.findByCnpj(cnpj);

        if (company == null)
            throw new InvalidDataException("Empresa não encontrada!");

        return company;
    }

    public List<Company> findAll() {
        try {
            return this.companyRepository.findAll();
        } catch (ErrorExecutionException e) {
            throw new ErrorExecutionException("Ocorreu um erro ao listar as empresad!");
        }
    }

    public void delete(String cnpj) {
        try {
            Company company = this.companyRepository.findByCnpj(cnpj);
            this.companyRepository.delete(company);
        } catch (ErrorExecutionException e) {
            throw new ErrorExecutionException("Ocorreu um erro ao remover a empresa!");
        }
    }
}
