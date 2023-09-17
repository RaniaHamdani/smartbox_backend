package com.qodexia.smartbox.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class NotMatchPasswordException extends AbstractThrowableProblem {
    public NotMatchPasswordException(final String message) {
        super(ErrorConstants.ENTITY_NOT_FOUND_TYPE, message, Status.NOT_FOUND);
    }
}
