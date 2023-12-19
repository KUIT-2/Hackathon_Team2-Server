package KUIT.CatchTable.Controller;

import KUIT.CatchTable.Common.response.BaseResponse;
import KUIT.CatchTable.Dto.store.GetCategoryStoreResponse;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import KUIT.CatchTable.Dto.store.GetHotPlaceResponse;
import KUIT.CatchTable.Dto.store.GetMenuStoreResponse;
import KUIT.CatchTable.Dto.store.GetReviewStoreResponse;
import KUIT.CatchTable.Service.StoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    /**
     * 가게 상세정보
     */
    @GetMapping("/detail/{storeId}")
    public BaseResponse<GetDetailedStoreResponse> getDetailedStore(
            @PathVariable("storeId") long storeId) {
        log.info("[StoreController.getDetailed]");

        return new BaseResponse<>(storeService.getDetailedStore(storeId));
    }

    /**
     * 카테고리별 가게 리스트
     */
    @GetMapping("/category/{categoryId}")
    public BaseResponse<List<GetCategoryStoreResponse>> getCategoryStore(
            @PathVariable("categoryId") long categoryId) {
        log.info("[StoreController.getCategoryStore]");

        return new BaseResponse<>(storeService.getCategoryStore(categoryId));
    }

    /**
     * 가게별 메뉴 리스트
     */
    @GetMapping("/menu/{storeId}")
    public BaseResponse<List<GetMenuStoreResponse>> getMenuStore(
            @PathVariable("storeId") long storeId) {
        log.info("[storeController.getMenuStore]");

        return new BaseResponse<>(storeService.getMenuStore(storeId));
    }

    /**
     * 핫플레이스 리스트
     */
    @GetMapping("/hotplace")
    public BaseResponse<List<GetHotPlaceResponse>> getHotplaceStore() {
        log.info("[StoreController.getHotplace]");

        return new BaseResponse<>(storeService.getHotplaceStore());
    }

    /**
     * 가게 리뷰 리스트
     */
    @GetMapping("review/{storeId}")
    public BaseResponse<List<GetReviewStoreResponse>> getReviewStore(
            @PathVariable("storeId") long storeId) {
        log.info("[StoreController.getReview]");

        return new BaseResponse<>(storeService.getReviewStore(storeId));
    }
}

//access, control, allow, origin - cors 필터 검색
//