package com.example.project.config;

import javax.servlet.ServletContext;

public interface WebConfigurationInterface {
    void registerHiddenFieldFilter(ServletContext aContext);
    void registerCharacterEncodingFilter(ServletContext aContext);
}
