package KUIT.CatchTable.Service;

import KUIT.CatchTable.Dao.StoreDao;
import KUIT.CatchTable.Dto.store.GetCategoryStoreResponse;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import KUIT.CatchTable.Dto.store.GetMenuStoreResponse;
import KUIT.CatchTable.Dto.store.GetReviewStoreResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreDao storeDao;

    public GetDetailedStoreResponse getDetailedStore(long storeId) {
        log.info("[StoreService.getDetail]");

        return storeDao.getDetailedStore(storeId);
    }

//    public GetFacilityStoreResponse getFacilityStore() {
//        log.info("[StoreService.getFacility]");
//
//        return new GetFacilityStoreResponse(storeDao.getFacilityStore())
//    }

    public List<GetCategoryStoreResponse> getCategoryStore(long categoryId) {
        log.info("[StoreService.getCategoryStore]");

        return storeDao.getCategoryStore(categoryId);
    }

    public List<GetMenuStoreResponse> getMenuStore(long storeId) {
        log.info("[StoreService.getMenuStore]");

        return storeDao.getMenuStore(storeId);
    }

    public List<GetCategoryStoreResponse> getHotplaceStore() {
        log.info("[StoreService.getHotplaceStore]");

        return storeDao.getHotplaceStore();
    }

    public List<GetReviewStoreResponse> getReviewStore(long storeId) {
        log.info("[StoreService.getReviewStore]");

        return storeDao.getReviewStore(storeId);
    }
}
