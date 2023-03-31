package com.example.project.config.impl;

import com.example.project.config.ApplicationConfiguration;
import com.example.project.config.WebConfigurationInterface;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

public class WebMvcApplicationConfigurationImpl extends AbstractAnnotationConfigDispatcherServletInitializer implements WebConfigurationInterface {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

//    @Override
//    public void onStartup(ServletContext aServletContext) throws ServletException {
//        super.onStartup(aServletContext);
//        registerCharacterEncodingFilter(aServletContext);
//        registerHiddenFieldFilter(aServletContext);
//    }

    @Override
    public void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                String.valueOf(new HiddenHttpMethodFilter())).addMappingForUrlPatterns(null, true, "/*");
    }

    @Override
    public void registerCharacterEncodingFilter(ServletContext aContext) {
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistration.Dynamic characterEncoding = aContext.addFilter("characterEncoding", String.valueOf(characterEncodingFilter));
        characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true, "/*");
    }
}
