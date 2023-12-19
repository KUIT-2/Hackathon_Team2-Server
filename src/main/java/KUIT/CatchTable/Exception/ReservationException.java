package KUIT.CatchTable.Exception;

import KUIT.CatchTable.Common.response.ResponseStatus;
import lombok.Getter;

@Getter
public class ReservationException extends RuntimeException{
    private final ResponseStatus exceptionStatus;


    public ReservationException(ResponseStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
        this.exceptionStatus = exceptionStatus;
    }

    public ReservationException(ResponseStatus exceptionStatus, String message){
        super(message);
        this.exceptionStatus = exceptionStatus;
    }
}
