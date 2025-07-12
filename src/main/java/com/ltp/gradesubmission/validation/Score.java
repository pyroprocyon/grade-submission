package com.ltp.gradesubmission.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ScoreValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface Score {

  String message() default "Grade must be a valid score";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
