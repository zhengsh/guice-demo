package cn.edu.cqive.filter;

import com.google.inject.Guice;
import com.google.inject.servlet.GuiceFilter;

import javax.servlet.annotation.WebFilter;

/**
 * @author ZAKJ_ASUS
 */
@WebFilter
public class SpringAwareGuiceFilter extends GuiceFilter {
}
