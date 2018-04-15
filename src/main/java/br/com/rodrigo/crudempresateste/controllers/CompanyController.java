package br.com.rodrigo.crudempresateste.controllers;

import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.models.Company;
import br.com.rodrigo.crudempresateste.services.CompanyService;
import java.util.ArrayList;
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
    public ResponseEntity<Company> save(@RequestBody CompanyDTO companyDTO) {

        validate(companyDTO);
        Company company = CompanyCreator.companyCreator(companyDTO);
        Company companySaved = this.companyService.save(company);
        return new ResponseEntity<>(companySaved, HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Company> update(@RequestBody Company company) {
        Company companyUpdated = this.companyService.save(company);
        return new ResponseEntity<>(companyUpdated, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAllCompanies() {
        List<Company> companies = this.companyService.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> findOneByid(@PathVariable Long id) {
        if (id == null)
            throw new IllegalArgumentException("O id da empresa é necessário!");

        Company company = this.companyService.findOneById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @GetMapping(value = "/{cnpj}/por_cnpj")
    public ResponseEntity<Company> findOneByid(@PathVariable String cnpj) {
        if (cnpj == null)
            throw new IllegalArgumentException("O id da empresa é necessário!");

        Company company = this.companyService.findOneByCnpj(cnpj);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Company> delete(@PathVariable Long id) {
        if (id == null)
            throw new IllegalArgumentException("O id da empresa é necessário!");

        this.companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void validate(CompanyDTO companyDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<CompanyDTO>> constraintViolations = factory.getValidator().validate(companyDTO);

        if(!constraintViolations.isEmpty())
            throw new IllegalArgumentException(takeTheFistCConstraint(constraintViolations));
    }

    private String takeTheFistCConstraint(Set<ConstraintViolation<CompanyDTO>> constraintViolations) {
      List<ConstraintViolation<CompanyDTO>> listconstraintViolations = new ArrayList<>(constraintViolations);
        return listconstraintViolations.get(0).getMessage();
    }


}
