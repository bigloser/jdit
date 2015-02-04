package com.github.arteam.dropwizard.testing.jdbi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Date: 1/25/15
 * Time: 6:50 PM
 * Inject a DBI DAO (class with DBI field) to a test
 *
 * @author Artem Prigoda
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TestedDao {
}