package com.rhmtech.lang.localelanguage;
import com.rhmtech.lang.localelanguage.config.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class LocalizationController {


    private final MessageService messageService;

    public LocalizationController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/greet")
    public String greet() {
        return messageService.getMessage("welcome.message");
    }

    @GetMapping("/error")
    public String errorMessage() {
        return messageService.getMessage("error.notfound");
    }
}