package kg.erkin.elasticsearchsecond.exception;

public class NoSuchItemException extends RuntimeException{
    public NoSuchItemException(Long id) {
        super("No found car with id " + id);
    }
}
