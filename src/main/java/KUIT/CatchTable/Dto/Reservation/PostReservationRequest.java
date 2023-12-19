package KUIT.CatchTable.Dto.Reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostReservationRequest {
    private long userId;
    private long storeId;
    private int reserveCount;
    private String reserveDay;
    private String reserveTime;
}
