package org.zeti.medical.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ResourceExist extends RuntimeException
{
    public ResourceExist() {
    }

    public ResourceExist(String message) {
        super(message);
    }
}
