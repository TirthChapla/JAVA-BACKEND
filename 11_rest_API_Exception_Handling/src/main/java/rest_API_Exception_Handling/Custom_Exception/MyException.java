package rest_API_Exception_Handling.Custom_Exception;

public class MyException extends RuntimeException
{
    public MyException()
    {}

    public MyException(String message)
    {
        super(message);
    }


}
