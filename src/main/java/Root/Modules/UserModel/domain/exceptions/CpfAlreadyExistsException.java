package Root.Modules.UserModel.domain.exceptions;

public class CpfAlreadyExistsException extends RuntimeException{

    public CpfAlreadyExistsException(String message) {
        super(message);
    }
}
