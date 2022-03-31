package com.security.donato.safely.utils;

import javax.validation.MessageInterpolator;
import java.util.Locale;

public class MessageInterpretator implements MessageInterpolator {

    private final MessageInterpolator messageInterpolator;

    public MessageInterpretator(MessageInterpolator interpolator) {
        this.messageInterpolator = interpolator;
    }

    @Override
    public String interpolate(String messageTemplate, Context context) {
        messageTemplate = messageTemplate.toUpperCase();
        return messageInterpolator.interpolate(messageTemplate, context);
    }

    @Override
    public String interpolate(String messageTemplate, Context context, Locale locale) {
        messageTemplate = messageTemplate.toUpperCase();
        return messageInterpolator.interpolate(messageTemplate, context, locale);
    }
}
