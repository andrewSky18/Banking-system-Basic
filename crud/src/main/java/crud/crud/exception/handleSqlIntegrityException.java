package crud.crud.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HandleSqlIntegrityException extends RuntimeException{

    private static final long serialVersionUID = 2L;

    public HandleSqlIntegrityException(String message) {
        super(message);
    }
}
