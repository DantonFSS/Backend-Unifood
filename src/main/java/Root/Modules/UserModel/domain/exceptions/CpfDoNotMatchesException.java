package Root.Modules.UserModel.domain.exceptions;

public class CpfDoNotMatchesException extends RuntimeException {
    public CpfDoNotMatchesException(String message) {
        super(message);
    }
}
