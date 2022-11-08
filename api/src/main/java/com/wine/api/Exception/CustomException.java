package api.src.main.java.com.wine.api.Exception;


public class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        this.message = message;
    }
}
