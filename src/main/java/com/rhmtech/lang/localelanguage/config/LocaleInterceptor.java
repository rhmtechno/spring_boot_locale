package com.rhmtech.lang.localelanguage.config;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.util.Locale;

@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String language = request.getHeader("Accept-Language");
        Locale locale = (language != null && !language.isEmpty()) ? Locale.forLanguageTag(language) : Locale.ENGLISH;
        LocaleContextHolder.setLocale(locale);
        return true;
    }
}