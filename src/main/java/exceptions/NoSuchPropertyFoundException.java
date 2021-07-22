package exceptions;

public class NoSuchPropertyFoundException extends UserFriendlyException{
    public NoSuchPropertyFoundException() {
        super(" Such property is not found");
    }
}
