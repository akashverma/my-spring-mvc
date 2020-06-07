package com.practice.myspringmvc;

import com.practice.myspringmvc.dtos.RegistrationForm;
import com.practice.myspringmvc.validator.BasicInfo;
import com.practice.myspringmvc.validator.constraintGroups.AdvanceInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class RegistrationFormUnitTest {
    private static Validator validator;

    @BeforeClass
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void whenBasicInfoIsNotComplete_thenShouldGiveConstraintViolationsOnlyForBasicInfo() {
        RegistrationForm form = buildRegistrationFormWithBasicInfo();
        form.setFirstName("");

        Set<ConstraintViolation<RegistrationForm>> violations = validator.validate(form, BasicInfo.class);

        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getMessage()).isEqualTo("must not be blank");
            assertThat(action.getPropertyPath().toString()).isEqualTo("firstName");
        });
    }

    private RegistrationForm buildRegistrationFormWithBasicInfo() {
        RegistrationForm form = new RegistrationForm();
        form.setFirstName("devender");
        form.setLastName("kumar");
        form.setEmail("anyemail@yopmail.com");
        form.setPhone("12345");
        form.setCaptcha("Y2HAhU5T");
        return form;
    }

}
