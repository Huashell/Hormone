package com.example.hormone.config.exception;

import java.io.Serial;


public class CustomException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -1202705508531564989L;

    public CustomException(String msg) {
        super(msg);
    }

}
