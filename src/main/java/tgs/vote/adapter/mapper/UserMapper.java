package tgs.vote.adapter.mapper;

import org.mapstruct.Mapper;
import tgs.vote.adapter.model.persistence.user.UserEntity;
import tgs.vote.adapter.model.web.user.SlackUserCreateRequest;
import tgs.vote.application.model.user.CreateUserInCommand;
import tgs.vote.domain.user.User;

@Mapper
public interface UserMapper {

    CreateUserInCommand toCreateUserInCommand(SlackUserCreateRequest request);

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

}
