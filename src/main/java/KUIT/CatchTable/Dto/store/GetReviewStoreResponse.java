package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class GetReviewStoreResponse {

    private String userName;
    private float avgScore;
    private String createAt;
    private String reviewImage;
    private String review;
}
