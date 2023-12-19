package KUIT.CatchTable.ExceptionHandler;

import KUIT.CatchTable.Common.response.BaseErrorResponse;
import KUIT.CatchTable.Exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.DATABASE_ERROR;

@RestControllerAdvice
@Slf4j
public class UserExceptionControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataAccessException.class)
    public BaseErrorResponse handle_UserException(UserException e) {
        log.error("[handle_UserException]", e);
        return new BaseErrorResponse(e.getExceptionStatus(), e.getMessage());
    }
}
