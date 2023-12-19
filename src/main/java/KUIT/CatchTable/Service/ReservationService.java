package KUIT.CatchTable.Service;

import KUIT.CatchTable.Dao.ReservationDao;
import KUIT.CatchTable.Dto.Reservation.GetReservationResponse;
import KUIT.CatchTable.Dto.Reservation.PostReservationRequest;
import KUIT.CatchTable.Dto.Reservation.PostReservationResponse;
import KUIT.CatchTable.Exception.ReservationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.FULL_RESERVATION;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationDao ReservationDao;

    public PostReservationResponse register(PostReservationRequest postReservationRequest) {
        log.info("[ReservationService.createReservation]");

        // TODO 1 : 예약가능여부 검사
        validateReservation(postReservationRequest.getStoreId(), postReservationRequest.getReserveDay(), postReservationRequest.getReserveTime(), postReservationRequest.getReserveCount());

        long reserveId = ReservationDao.createReservation(postReservationRequest);
        return new PostReservationResponse(reserveId);
    }

    private void validateReservation(long storeId, String reserveDay, String reserveTime, int reserveCount) {
        if(ReservationDao.isFullResevation(storeId, reserveDay, reserveTime, reserveCount)){
            throw new ReservationException(FULL_RESERVATION);
        }
    }

    public List<GetReservationResponse> getPossibleReservationTime(long storeId, String day, int reserveCount) {
        log.info("[ReservationService.getPossibleReservationTime]");
        return ReservationDao.getPossibleReservationTime(storeId, day, reserveCount);
    }
}
