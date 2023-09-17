package com.qodexia.smartbox.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class NullRoleException extends AbstractThrowableProblem {

    public NullRoleException(final String message) {
        super(ErrorConstants.ENTITY_NOT_FOUND_TYPE, message, Status.NOT_FOUND);
    }
}
