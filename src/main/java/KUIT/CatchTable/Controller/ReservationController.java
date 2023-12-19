package KUIT.CatchTable.Controller;

import KUIT.CatchTable.Common.response.BaseResponse;
import KUIT.CatchTable.Dto.Reservation.GetReservationResponse;
import KUIT.CatchTable.Dto.Reservation.PostReservationRequest;
import KUIT.CatchTable.Dto.Reservation.PostReservationResponse;
import KUIT.CatchTable.Service.ReservationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    /**
     * 예약 등록
     */
    @PostMapping("")
    public BaseResponse<PostReservationResponse> register(@Validated @RequestBody PostReservationRequest postReservationRequest){
        log.info("[ReservationController.signUp]");

        return new BaseResponse<>(reservationService.register(postReservationRequest));
    }

    /**
     * 예약 가능 시간 조회
     */
    @GetMapping("?store_id={storeId}&day={day}&possible_people_number={possible_people_number}")
    public BaseResponse<List<GetReservationResponse>> getPossibleReservationTime(
            @RequestParam(required = false, defaultValue = "") long storeId,
            @RequestParam(required = false, defaultValue = "") String day,
            @RequestParam(required = false, defaultValue = "") int reserveCount){
        log.info("[ReservationController.getPossibleReservationTime]");
        return new BaseResponse<>(reservationService.getPossibleReservationTime(storeId, day, reserveCount));
    }

}
