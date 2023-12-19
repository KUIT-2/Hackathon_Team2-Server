package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetCategoryStoreResponse {

    private String storeImage;
    private String storeName;
    private String storeDesc;
    private float avgScore;
    private int countScore;
}
