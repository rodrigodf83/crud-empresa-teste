package br.com.rodrigo.crudempresateste.controllers;

import br.com.rodrigo.crudempresateste.converters.CompanyConverter;
import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.exceptions.InvalidDataException;
import br.com.rodrigo.crudempresateste.models.Company;
import br.com.rodrigo.crudempresateste.services.CompanyService;
import br.com.rodrigo.crudempresateste.validators.CompanyDtoValidator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> save(@RequestBody CompanyDTO companyDTO) {

        CompanyDtoValidator.validateCompanyDTO(companyDTO);
        Company company = CompanyConverter.companyConverter(companyDTO, null);
        Company companySaved = this.companyService.save(company);
        companyDTO = CompanyConverter.companyDTOConverter(companySaved);

        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO companyDTO) {
        CompanyDtoValidator.validateCompanyDTO(companyDTO);
        Company companyUpdated = this.companyService.update(companyDTO);
        companyDTO = CompanyConverter.companyDTOConverter(companyUpdated);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAllCompanies() {
        List<Company> companies = this.companyService.findAll();
        List<CompanyDTO> companyDTOList = companiesConverte(companies);
        return new ResponseEntity<>(companyDTOList, HttpStatus.OK);
    }


    @GetMapping(value = "/{cnpj}/por_cnpj")
    public ResponseEntity<CompanyDTO> findOneByCnpj(@PathVariable String cnpj) {
        if (cnpj == null)
            throw new InvalidDataException("O id da empresa é necessário!");

        Company company = this.companyService.findOneByCnpj(cnpj);
        CompanyDTO companyDTO = CompanyConverter.companyDTOConverter(company);
        return new ResponseEntity<>(companyDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{cnpj}")
    public ResponseEntity<Company> delete(@PathVariable String cnpj) {
        if (cnpj == null || cnpj == "")
            throw new InvalidDataException("O id da empresa é necessário!");

        this.companyService.delete(cnpj);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private List<CompanyDTO> companiesConverte(List<Company> companies) {
        List<CompanyDTO> companyDTOList = new LinkedList<>();
        companies.forEach(company -> {
            CompanyDTO companyDTO = CompanyConverter.companyDTOConverter(company);
            companyDTOList.add(companyDTO);
        });
        return companyDTOList;
    }


}
