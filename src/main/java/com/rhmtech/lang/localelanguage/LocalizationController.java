package com.rhmtech.lang.localelanguage;
import com.rhmtech.lang.localelanguage.config.MessageService;
import com.rhmtech.lang.localelanguage.data.LocalMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalizationController {


    private final MessageService messageService;

    public LocalizationController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/greet")
    public String greet() {
        return messageService.getMessage(LocalMessage.WELCOME_MESSAGE);
    }

    @GetMapping("/error")
    public String errorMessage() {
        return messageService.getMessage(LocalMessage.ERROR_NOT_FOUND);
    }
}