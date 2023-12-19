package KUIT.CatchTable.Controller;

import KUIT.CatchTable.Common.response.BaseResponse;
import KUIT.CatchTable.Dto.user.LoginRequest;
import KUIT.CatchTable.Dto.user.LoginResponse;
import KUIT.CatchTable.Dto.user.PostUserRequest;
import KUIT.CatchTable.Dto.user.PostUserResponse;
import KUIT.CatchTable.Exception.UserException;
import KUIT.CatchTable.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.INVALID_USER_VALUE;
import static KUIT.CatchTable.util.BindingResultUtils.getErrorMessages;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    /**
     * 회원 가입
     */
    @PostMapping("")
    public BaseResponse<PostUserResponse> signUp(@Validated @RequestBody PostUserRequest postUserRequest, BindingResult bindingResult){
        log.info("[UserController.signUp]");

        if(bindingResult.hasErrors()){
            throw new UserException(INVALID_USER_VALUE, getErrorMessages(bindingResult));
        }
        return new BaseResponse<>(userService.signUp(postUserRequest));
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest, BindingResult bindingResult){
        log.info("[UserController.login]");
        if(bindingResult.hasErrors()){
            throw new UserException(INVALID_USER_VALUE, getErrorMessages(bindingResult));
        }
        return new BaseResponse<>(userService.login(loginRequest));
    }
}
