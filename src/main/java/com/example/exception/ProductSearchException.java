package com.example.exception;

/**
 * @author Ramesh.Yaleru on 6/25/2021
 */
public class ProductSearchException extends RuntimeException{
    private static final long serialVersionUID = 8604003512728611871L;
    private  String errorCode;
    /**
     * The errorCode is the same as the fully qualified classname of this
     * exception.
     */
    public static final String ERROR_CODE = ProductSearchException.class.getName();


    /**
     * @param cause Original cause of the exception, use with caution since
     * clients must include the class of the cause also (e.g. a
     * vendor specific database exception should not be exposed to
     * clients).
     */
    public ProductSearchException(Exception cause) {
        this(cause.getMessage(), cause);
    }


    /**
     * @param message Technical message. Used for debugging purpose, not intended
     * for end users.
     */
    public ProductSearchException(String message) {
        this(ERROR_CODE, message, null);
    }


    /**
     * @param message Technical message. Used for debugging purpose, not intended
     * for end users.
     * @param cause Original cause of the exception, use with caution since
     * clients must include the class of the cause also (e.g. a
     * vendor specific database exception should not be exposed to
     * clients).
     */
    public ProductSearchException(String message, Throwable cause) {
        this(ERROR_CODE, message, cause);
    }

    public ProductSearchException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public ProductSearchException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }




    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
