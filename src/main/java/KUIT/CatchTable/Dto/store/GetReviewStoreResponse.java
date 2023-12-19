package KUIT.CatchTable.Dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetReviewStoreResponse {

    private String userName;
    private float avgScore;
    private String createAt;
    private String reviewImage;
    private String review;
}
