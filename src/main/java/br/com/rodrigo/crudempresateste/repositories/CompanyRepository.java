package br.com.rodrigo.crudempresateste.repositories;

import br.com.rodrigo.crudempresateste.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    public Company findOneById(Long id);

    public Company findByCnpj(String Cnpj);
}
