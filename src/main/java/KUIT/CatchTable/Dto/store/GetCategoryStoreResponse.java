package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetCategoryStoreResponse {

    private String storeImage;
    private String storeName;
    private String storeDesc;
    private float avgScore;
    private int countScore;
}
