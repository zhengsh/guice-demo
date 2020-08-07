package cn.edu.cqvie.guice.helloworld;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author ZAKJ_ASUS
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Output {
}
