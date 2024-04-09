package za.co.aboutblank.exceptions;

public class InvalidCardException extends Exception{
    public InvalidCardException(String errorMessage) {
        super(errorMessage);
    }
}
