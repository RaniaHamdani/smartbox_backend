package com.qodexia.smartbox.exceptions;

import org.zalando.problem.StatusType;

import java.time.ZonedDateTime;
import java.util.List;

@SuppressWarnings("CanBeFinal")
public class ExceptionDTO {
    private  List<String> message;
    private  StatusType httpStatus;
    private  ZonedDateTime time;
    private  String constraintName;

    public String getConstraintName() {
        return constraintName;
    }

    public ExceptionDTO(List<String> message, ZonedDateTime time, String constraintName) {
        this.message = message;
        this.time = time;
        this.constraintName = constraintName;
    }

    public ExceptionDTO(List<String> message, StatusType httpStatus, ZonedDateTime time, String constraintName) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
        this.constraintName = constraintName;
    }

    public ExceptionDTO(List<String> message, StatusType httpStatus, ZonedDateTime time) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public List<String> getMessage() {
        return message;
    }

    public StatusType getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
