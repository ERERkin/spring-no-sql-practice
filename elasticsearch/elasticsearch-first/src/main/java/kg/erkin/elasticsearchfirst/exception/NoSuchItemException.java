package kg.erkin.elasticsearchfirst.exception;

public class NoSuchItemException extends RuntimeException{
    public NoSuchItemException(Long id) {
        super("No found employee with id " + id);
    }
}
