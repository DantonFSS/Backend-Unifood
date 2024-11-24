package Root.shared.common.utils.exceptions;

public class HttpBadRequestException extends RuntimeException {
    public HttpBadRequestException (String message) {
        super(message);
    }
}
