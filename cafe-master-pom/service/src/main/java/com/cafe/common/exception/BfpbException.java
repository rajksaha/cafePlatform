package com.cafe.common.exception;


public class BfpbException extends Exception {
    private static final long serialVersionUID = 8761763194763355804L;


    public BfpbException(String message) {
        super(message);
    }


    public BfpbException(String message, Throwable ex) {
        super(message, ex);
    }

}
