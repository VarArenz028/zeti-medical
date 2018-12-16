package org.zeti.medical.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.zeti.medical.exception.details.ErrorDetails;
import org.zeti.medical.exception.details.ValidationDetail;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    // validation exception
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request)
    {
        List<ValidationDetail> validationDetails = validationDetails(e);
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
                "Validation failed",
                HttpStatus.BAD_REQUEST.value(),
                validationDetails);
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public final ResponseEntity<ErrorDetails> resourceNotFound(ResourceNotFound e,
                                                               HttpServletRequest servletRequest,
                                                               NativeWebRequest nativeWebRequest)
    {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
                e.getMessage(),
                "Not Found",
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExist.class)
    public final ResponseEntity<ErrorDetails> resourceConfict(ResourceExist e)
    {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
                e.getMessage(),
                "Conflict",
                HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(details, HttpStatus.CONFLICT);
    }

    // gets all validation details
    private List<ValidationDetail> validationDetails(MethodArgumentNotValidException e)
    {
        List<ValidationDetail> validationDetails = new LinkedList<>();
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();

        for (FieldError fieldError : fieldErrors)
        {
            ValidationDetail detail = new ValidationDetail(fieldError.getDefaultMessage(),
                    fieldError.getField(),
                    fieldError.getRejectedValue());
            validationDetails.add(detail);
        }

        return validationDetails;
    }
}
