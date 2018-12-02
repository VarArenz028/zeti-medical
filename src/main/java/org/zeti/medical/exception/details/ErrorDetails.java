package org.zeti.medical.exception.details;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorDetails
{
    private LocalDateTime dateTime;
    private Object message;
    private String error;
    private Integer status;
    private List<ValidationDetail> validationDetails;

    public ErrorDetails(LocalDateTime dateTime, Object message, String error, Integer status) {
        this.dateTime = dateTime;
        this.message = message;
        this.error = error;
        this.status = status;
    }

    public ErrorDetails(LocalDateTime dateTime, Object message, Integer status, List<ValidationDetail> validationDetails) {
        this.dateTime = dateTime;
        this.message = message;
        this.status = status;
        this.validationDetails = validationDetails;
    }

    public ErrorDetails(LocalDateTime dateTime, String error, Integer status, List<ValidationDetail> validationDetails) {
        this.dateTime = dateTime;
        this.error = error;
        this.status = status;
        this.validationDetails = validationDetails;
    }

    public ErrorDetails(LocalDateTime dateTime, Object message, String error, Integer status, List<ValidationDetail> validationDetails) {
        this.dateTime = dateTime;
        this.message = message;
        this.error = error;
        this.status = status;
        this.validationDetails = validationDetails;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ValidationDetail> getValidationDetails() {
        return validationDetails;
    }

    public void setValidationDetails(List<ValidationDetail> validationDetails) {
        this.validationDetails = validationDetails;
    }
}
