package com.cafe.common.exception;


public class CafeException extends Exception {
    private static final long serialVersionUID = 8761763194763355804L;


    public CafeException(String message) {
        super(message);
    }


    public CafeException(String message, Throwable ex) {
        super(message, ex);
    }

}
