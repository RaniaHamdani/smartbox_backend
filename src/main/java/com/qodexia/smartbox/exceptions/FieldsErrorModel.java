package com.qodexia.smartbox.exceptions;

import java.io.Serializable;

public class FieldsErrorModel implements Serializable {
    private final String objectName;
    private final String field;
    private final String message;

    public FieldsErrorModel(String objectName, String field, String message) {
        this.objectName = objectName;
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
