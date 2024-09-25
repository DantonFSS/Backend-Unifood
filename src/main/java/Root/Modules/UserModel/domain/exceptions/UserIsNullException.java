package Root.Modules.UserModel.domain.exceptions;

public class UserIsNullException extends RuntimeException {

    public UserIsNullException(String message) {
        super(message);
    }
}
