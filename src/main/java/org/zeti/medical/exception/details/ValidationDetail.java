package org.zeti.medical.exception.details;

public class ValidationDetail
{
    private String validationMessage;
    private String field;
    private Object rejectedValue;

    public ValidationDetail() {
    }

    public ValidationDetail(String validationMessage, String field, Object rejectedValue) {
        this.validationMessage = validationMessage;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

}
