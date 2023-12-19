package KUIT.CatchTable.Service;

import KUIT.CatchTable.Dao.StoreDao;
import KUIT.CatchTable.Dto.store.GetDetailedStoreResponse;
import KUIT.CatchTable.Dto.store.GetFacilityStoreResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final StoreDao storeDao;

    public GetDetailedStoreResponse getDetailedStore() {

    }

    public GetFacilityStoreResponse getFacilityStore() {

    }
}
