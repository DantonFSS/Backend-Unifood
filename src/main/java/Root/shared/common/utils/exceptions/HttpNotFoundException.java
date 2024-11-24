package Root.shared.common.utils.exceptions;

public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(String message) {
        super(message);
    }
}
