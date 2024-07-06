package com.scaler.productservicejune24.controlleradvice;

import com.scaler.productservicejune24.Models.Product;
import com.scaler.productservicejune24.dtos.ExceptionDTO;
import com.scaler.productservicejune24.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handlerArithmeticException()
//    {
//        ResponseEntity<String> resp = new ResponseEntity<String>(
//                "Something went wrong, coming from controladvice",
//                HttpStatus.BAD_REQUEST
//        );
//        return resp;
//    }

    //we can use DTO to show the error in our way
//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<ExceptionDTO> handleArithmeticException()
//    {
//        ExceptionDTO exc = new ExceptionDTO();
//        exc.setException("Division by zero happened");
//        exc.setResolution("Check the expression again");
//        ResponseEntity<ExceptionDTO> resp = new ResponseEntity<>(
//                exc, HttpStatus.BAD_REQUEST
//        );
//        return resp;
//    }

    //using exception that is customized
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleProductNotFoundException()
    {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setException("Product Not Found with the given id");
        exceptionDTO.setResolution("Please enter a correct product id");
        ResponseEntity<ExceptionDTO> resp = new ResponseEntity<>(
               exceptionDTO, HttpStatus.BAD_GATEWAY
        );
        return resp;
    }

    //exceptions that are thrown from the service or controller, if those exceptions
    // will be handled in controladvice, then only it will be caught. Otherwise nothing
    // will happen and the error will be displayed on the screen with full stack trace.
}
