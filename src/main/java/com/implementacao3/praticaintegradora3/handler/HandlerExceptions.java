package com.implementacao3.praticaintegradora3.handler;

import com.implementacao3.praticaintegradora3.exceptions.ExcpetionDetails;
import com.implementacao3.praticaintegradora3.exceptions.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler (IdNotFoundException.class)
    public ResponseEntity<ExcpetionDetails> handlerIdNotFound (IdNotFoundException idNotFound){
        return new ResponseEntity<>(
                ExcpetionDetails.builder()
                        .title("Erro no id")
                        .message(idNotFound.getMessage())
                        .fields("id")
                        .status(HttpStatus.NOT_FOUND.value())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

}
