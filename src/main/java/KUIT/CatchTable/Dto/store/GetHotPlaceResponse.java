package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetHotPlaceResponse {

    private long storeId;
    private String storeName;
    private float stars;
    private String categoryName;
    private String address;
}

