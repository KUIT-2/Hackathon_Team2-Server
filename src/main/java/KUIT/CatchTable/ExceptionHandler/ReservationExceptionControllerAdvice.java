package KUIT.CatchTable.ExceptionHandler;

import KUIT.CatchTable.Common.response.BaseErrorResponse;
import KUIT.CatchTable.Exception.ReservationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.DATABASE_ERROR;

@RestControllerAdvice
@Slf4j
public class ReservationExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReservationException.class)
    public BaseErrorResponse handle_DataAccessException(ReservationException e) {
        log.error("[handle_ReservationException]", e);
        return new BaseErrorResponse(e.getExceptionStatus(), e.getMessage());
    }
}
