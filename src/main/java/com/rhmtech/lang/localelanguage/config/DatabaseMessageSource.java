package com.rhmtech.lang.localelanguage.config;

import com.rhmtech.lang.localelanguage.data.entity.Message;
import com.rhmtech.lang.localelanguage.data.repo.MessageRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Optional;

@Service
public class DatabaseMessageSource extends AbstractMessageSource {

    private final MessageRepository messageRepository;

    public DatabaseMessageSource(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    protected MessageFormat resolveCode(String code, Locale locale) {
        String localeString = locale.toLanguageTag(); // e.g., "en", "bn"
        Optional<String> messageOpt = messageRepository
                .findByMessageKeyAndLocale(code, localeString)
                .map(Message::getMessageValue);

        return messageOpt.map(msg -> new MessageFormat(msg, locale)).orElse(null);
    }
}