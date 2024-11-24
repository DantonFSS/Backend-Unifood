package Root.shared.common.utils.exceptions.httpex;

import Root.shared.common.utils.exceptions.HttpBadRequestException;
import Root.shared.common.utils.exceptions.HttpNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<ApplicationError> applicationBadRequestException (
            RuntimeException ex,
            HttpServletRequest request) {

        log.error("Application bad request - ", ex);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApplicationError(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<ApplicationError> applicationNotFoundException (
            RuntimeException ex,
            HttpServletRequest request) {

        log.error("Application not found - ", ex);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApplicationError(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApplicationError> methodArgumentNotValidException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request,
            BindingResult result) {

        log.error("Field validation error: ", ex);

        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApplicationError(request, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid Field", result));
    }



}
