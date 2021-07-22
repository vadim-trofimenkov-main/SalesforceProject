package exceptions;

public class UserFriendlyException extends RuntimeException{

    public UserFriendlyException(String message) {
        super(message);
    }
}
