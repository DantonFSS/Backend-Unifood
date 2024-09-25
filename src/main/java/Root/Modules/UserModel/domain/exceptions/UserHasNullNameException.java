package Root.Modules.UserModel.domain.exceptions;

public class UserHasNullNameException extends RuntimeException {

    public UserHasNullNameException(String message) {
        super(message);
    }
}
