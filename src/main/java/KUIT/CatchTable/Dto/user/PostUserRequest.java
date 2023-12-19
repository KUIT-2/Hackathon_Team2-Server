package KUIT.CatchTable.Dto.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostUserRequest {
    private String Id;
    private String password;
    private String name;
    private String phoneNumber;
}
