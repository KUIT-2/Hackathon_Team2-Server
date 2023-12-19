package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailedStoreResponse {

    private String storeName;
    private String storeDesc;
    private String storeImage;
    private float avgScore;
    private int countScore;
    private String categoryName;
    private String address;
}
