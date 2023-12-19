package KUIT.CatchTable.Service;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.DATABASE_ERROR;

import KUIT.CatchTable.Dao.StoreDao;
import KUIT.CatchTable.Dto.store.GetCategoryStoreResponse;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import KUIT.CatchTable.Dto.store.GetMenuStoreResponse;
import KUIT.CatchTable.Dto.store.GetReviewStoreResponse;
import KUIT.CatchTable.Exception.StoreException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreDao storeDao;

    public GetDetailedStoreResponse getDetailedStore(long storeId) {
        log.info("[StoreService.getDetail]");

        try {
            return storeDao.getDetailedStore(storeId);
        } catch (EmptyResultDataAccessException e) {
            throw new StoreException(DATABASE_ERROR);
        }
    }

//    public GetFacilityStoreResponse getFacilityStore() {
//        log.info("[StoreService.getFacility]");
//
//        return new GetFacilityStoreResponse(storeDao.getFacilityStore())
//    }

    public List<GetCategoryStoreResponse> getCategoryStore(long categoryId) {
        log.info("[StoreService.getCategoryStore]");

        try {
            return storeDao.getCategoryStore(categoryId);
        } catch (EmptyResultDataAccessException e) {
            throw new StoreException(DATABASE_ERROR);
        }
    }

    public List<GetMenuStoreResponse> getMenuStore(long storeId) {
        log.info("[StoreService.getMenuStore]");

        try {
            return storeDao.getMenuStore(storeId);
        } catch (EmptyResultDataAccessException e) {
            throw new StoreException(DATABASE_ERROR);
        }
    }

    public List<GetCategoryStoreResponse> getHotplaceStore() {
        log.info("[StoreService.getHotplaceStore]");

        return storeDao.getHotplaceStore();
    }

    public List<GetReviewStoreResponse> getReviewStore(long storeId) {
        log.info("[StoreService.getReviewStore]");

        try {
            return storeDao.getReviewStore(storeId);
        } catch (EmptyResultDataAccessException e) {
            throw new StoreException(DATABASE_ERROR);
        }
    }
}
