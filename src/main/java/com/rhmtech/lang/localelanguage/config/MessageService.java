package com.rhmtech.lang.localelanguage.config;
import com.rhmtech.lang.localelanguage.data.LocalMessage;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageSource messageSource;

    public MessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(LocalMessage localMessege) {
        return messageSource.getMessage(localMessege.getKey(), null, LocaleContextHolder.getLocale());
    }
}