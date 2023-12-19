package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetDetailedStoreResponse {

//    store_name, store_desc, store_image, avg(total_stars), count(score), category_name, address

    private String storeName;
    private String storeDesc;
    private String storeImage;
    private float avgScore;
    private int countScore;
    private String categoryName;
    private String address;
}
