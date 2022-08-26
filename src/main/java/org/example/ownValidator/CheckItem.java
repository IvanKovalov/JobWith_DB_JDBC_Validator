package org.example.ownValidator;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class CheckItem {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Logger logger = LoggerFactory.getLogger(CheckItem.class);

    public boolean check(Object objectForCheck){
        Set<ConstraintViolation<Object>> violations = validator.validate(objectForCheck);
        for (ConstraintViolation<Object> violation : violations) {
            if(violation.getMessage() == null){
                return false;
            }
            logger.info(violation.getMessage());
        }
        return true;
    }

}
