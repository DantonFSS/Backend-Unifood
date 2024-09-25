package Root.Modules.UserModel.infra;

import Root.Modules.UserModel.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CpfAlreadyExistsException.class)
    private ResponseEntity<String> CpfAlreadyExistsHandler(CpfAlreadyExistsException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("O Cpf já esta cadastrado!");
    }
    @ExceptionHandler(EmailAlreadyUsedException.class)
    private ResponseEntity<String> EmailAlreadyExistsHandler(EmailAlreadyUsedException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Este email já existe.");
    }
    @ExceptionHandler(UserNullCpfException.class)
    private ResponseEntity<String> UserNullCpfHandler(UserNullCpfException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("O Cpf não pode ser nulo.");
    }
    @ExceptionHandler(UserHasNullNameException.class)
    private ResponseEntity<String> UserHasNullName(UserHasNullNameException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O nome não pode ser nulo.");
    }
    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity<String> UserNotFoundHandler(UserNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
    }
    @ExceptionHandler(UserAlreadyExists.class)
    private ResponseEntity<String> UserAlreadyExistsHandler(UserAlreadyExists ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de usuário já registrado.");
    }
    @ExceptionHandler(CpfDoNotMatchesException.class)
    private ResponseEntity<String> CpfDoesntMatches(CpfDoNotMatchesException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cpf não está no formato - XXX.XXX.XXX-XX)...");
    }
}
