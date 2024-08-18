package tgs.vote.adapter.mapper;

import org.mapstruct.Mapper;
import tgs.vote.adapter.model.user.LoginResponse;
import tgs.vote.adapter.model.user.SlackLoginRequest;
import tgs.vote.adapter.model.user.UserEntity;
import tgs.vote.application.model.user.LoginInCommand;
import tgs.vote.application.model.user.LoginOutResult;
import tgs.vote.domain.user.User;

@Mapper
public interface UserMapper {

    LoginInCommand toCreateUserInCommand(SlackLoginRequest request);

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

    LoginResponse toLoginResponse(LoginOutResult result);
}
