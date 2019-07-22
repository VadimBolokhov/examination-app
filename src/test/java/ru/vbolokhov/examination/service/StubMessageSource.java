package ru.vbolokhov.examination.service;

import org.springframework.context.support.AbstractMessageSource;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * Stub for MessageSource.
 * @author Vadim Bolokhov
 */
public class StubMessageSource extends AbstractMessageSource {
    @Override
    protected MessageFormat resolveCode(String s, Locale locale) {
        return new MessageFormat("");
    }
}
