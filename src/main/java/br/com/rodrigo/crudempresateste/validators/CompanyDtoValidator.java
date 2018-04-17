package br.com.rodrigo.crudempresateste.validators;

import br.com.rodrigo.crudempresateste.dtos.AdressDTO;
import br.com.rodrigo.crudempresateste.dtos.CompanyDTO;
import br.com.rodrigo.crudempresateste.exceptions.InvalidDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class CompanyDtoValidator {

    public static void validateCompanyDTO(CompanyDTO companyDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<CompanyDTO>> constraintViolations = factory.getValidator().validate(companyDTO);

        if(!constraintViolations.isEmpty())
            throw new InvalidDataException(takeTheFistCConstraintInCompanyDTO(constraintViolations));
    }

    public static void validateAdressDTO(AdressDTO adressDTO) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<AdressDTO>> constraintViolations = factory.getValidator().validate(adressDTO);

        if(!constraintViolations.isEmpty())
            throw new InvalidDataException(takeTheFistCConstraintInAdressDTO(constraintViolations));
    }

    private static String takeTheFistCConstraintInCompanyDTO(Set<ConstraintViolation<CompanyDTO>> constraintViolations) {
        List<ConstraintViolation<CompanyDTO>> listconstraintViolations = new ArrayList<>(constraintViolations);
        return listconstraintViolations.get(0).getMessage();
    }

    private static String takeTheFistCConstraintInAdressDTO(Set<ConstraintViolation<AdressDTO>> constraintViolations) {
        List<ConstraintViolation<AdressDTO>> listconstraintViolations = new ArrayList<>(constraintViolations);
        return listconstraintViolations.get(0).getMessage();
    }
}
