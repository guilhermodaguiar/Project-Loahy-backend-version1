package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.exeptions.UserEmailExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserEmailExistException.class)
        public ResponseEntity<Object> handleUsernameExistsException(UserEmailExistException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
