package com.rhmtech.lang.localelanguage.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocaleConfig {

    private final DatabaseMessageSource databaseMessageSource;

    public LocaleConfig(DatabaseMessageSource databaseMessageSource) {
        this.databaseMessageSource = databaseMessageSource;
    }
    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();
        resolver.setDefaultLocale(Locale.US); // Default locale
        resolver.setSupportedLocales(List.of(
                Locale.US,    // English
                Locale.FRANCE, // French
                new Locale("bn") // Bengali
        ));
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        return databaseMessageSource;
    }
}