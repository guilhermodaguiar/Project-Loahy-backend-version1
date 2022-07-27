package nl.novi.project_loahy_backend.controller;

import nl.novi.project_loahy_backend.exeptions.CostumerEmailExistException;
import nl.novi.project_loahy_backend.exeptions.UsernameNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CostumerEmailExistException.class)
        public ResponseEntity<Object> handleUsernameExistsException(CostumerEmailExistException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> handleUserNameNotFoundException(UsernameNotFoundException exception) {

        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
