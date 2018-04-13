package br.com.rodrigo.crudempresateste.services;

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
            return this.companyRepository.saveAndFlush(company);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Company findOneById(Long id) {

        Company company = this.companyRepository.findOneById(id);

        if (company == null)
            throw new IllegalArgumentException("Empresa não encontrada!");

        return company;
    }

    public Company findOneByCnpj(String cnpj) {

        Company company = this.companyRepository.findByCnpj(cnpj);

        if (company == null)
            throw new IllegalArgumentException("Empresa não encontrada!");

        return company;
    }

    public List<Company> findAll() {
        try {
            return this.companyRepository.findAll();
        } catch (RuntimeException e) {
            throw new RuntimeException("Ocorreu um erro ao listar as empresad!");
        }
    }

    public void delete(Long id) {
        try {
            this.companyRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("Ocorreu um erro ao remover a empresa!");
        }
    }
}
