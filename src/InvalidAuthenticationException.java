public class InvalidAuthenticationException extends Exception{
    String message;

    public InvalidAuthenticationException(String message) {
        super(message);
        this.message = message;
    }
}
