package com.rhmtech.lang.localelanguage.data;

import lombok.Getter;


@Getter
public enum LocalMessage {
    WELCOME_MESSAGE("welcome.message"),
    ERROR_NOT_FOUND("error.notfound");

    private final String key;

    LocalMessage(String key) {
        this.key = key;
    }

}
