package KUIT.CatchTable.Controller;

import KUIT.CatchTable.Common.response.BaseResponse;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import KUIT.CatchTable.Service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    /**
     * 가게 상세정보
     */
    @GetMapping("/detail/{storeId}")
    public GetDetailedStoreResponse getDetailedStore(@PathVariable("storeId") long storeId) {
        log.info("[StoreController.getDetailed]");

        return new BaseResponse<>(storeService.)
    }

    @GetMapping("/home/{storeId}")
    public GetFacilityStoreResponse getFacilityStore(@PathVariable("storeId") long storeId) {
        log.info("[StoreController.getFacility]");
    }

    /**
     * 카테고리별 가게 리스트
     */
    @GetMapping("/{categoryId}")
    public
}

//
