package KUIT.CatchTable.Service;

import KUIT.CatchTable.Common.response.ResponseStatus;
import KUIT.CatchTable.Dao.UserDao;
import KUIT.CatchTable.Dto.user.LoginRequest;
import KUIT.CatchTable.Dto.user.LoginResponse;
import KUIT.CatchTable.Dto.user.PostUserRequest;
import KUIT.CatchTable.Dto.user.PostUserResponse;
import KUIT.CatchTable.Exception.UserException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.web.bind.annotation.RestController;

import static KUIT.CatchTable.Common.response.BaseResponseStatus.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    public PostUserResponse signUp(PostUserRequest postUserRequest) {
        log.info("[UserService.createUser]");

        validateId(postUserRequest.getId());

        long userId = userDao.createUser(postUserRequest);

        return new PostUserResponse(userId);
    }

    private void validateId(String id) {
        if(userDao.hasDuplicateId(id)){
            throw new UserException(DUPLICATE_ID);
        }
    }

    public LoginResponse login(LoginRequest loginRequest) {
        log.info("[UserService.login]");

        String id = loginRequest.getId();

        // TODO 1 : ID 유효성 확인
        long userId;
        try{
            userId = userDao.getUserIdById(id);
        } catch (IncorrectResultSizeDataAccessException e){
            throw new UserException(ID_NOT_FOUND);
        }

        // TODO 2 : 비밀번호 일치 확인
        validatePassword(loginRequest.getPassword(), userId);

        return new LoginResponse(userId);
    }

    private void validatePassword(String password, long userId) {
        String signedPassword = userDao.getPasswordByUserId(userId);
        if(!signedPassword.equals(password) ){
            throw new UserException(PASSWORD_NO_MATCH);
        }
    }
}
