package rest_API_Exception_Handling.Global_Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rest_API_Exception_Handling.Controller_Exceptions.TrainErrorResponce;
import rest_API_Exception_Handling.Custom_Exception.MyException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class Handel_Exception
{

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<TrainErrorResponce> handelNoSuchElementException(NoSuchElementException e)
    {
        TrainErrorResponce responce = new TrainErrorResponce("Train Not Found -> "+e.getMessage() , "404", false );

        ResponseEntity responseEntity = new ResponseEntity(responce , HttpStatus.NOT_FOUND);

        return responseEntity ;
    }


    // ❤️❤️❤️❤️ CUSTOM EXCEPTION

    @ExceptionHandler(MyException.class)
    public ResponseEntity<MyException> handelMyException(MyException e)
    {
        MyException responce = new MyException(e.getMessage());

        ResponseEntity responseEntity = new ResponseEntity(responce , HttpStatus.NOT_FOUND);

        return responseEntity ;
    }


}
