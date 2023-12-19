package KUIT.CatchTable.ExceptionHandler;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.DATABASE_ERROR;

import KUIT.CatchTable.Common.response.BaseErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class DatabaseExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataAccessException.class)
    public BaseErrorResponse handle_DataAccessException(DataAccessException e) {
        log.error("[handle_DataAccessException]", e);
        return new BaseErrorResponse(DATABASE_ERROR);
    }
}
