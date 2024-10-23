package Root.modules.users.domain.dtos.mappers;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.request.AllUserDto;
import Root.modules.users.domain.dtos.request.CreateUserDto;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.dtos.response.CreateUserResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public static UserModel mappingToUserEntity(CreateUserDto createDto) {
        return new UserModel(
                createDto.getCpf(),
                createDto.getName(),
                createDto.getEmail(),
                createDto.getPhone(),
                LocalDateTime.now()
        );
    }

    public static CreateUserResponseDto mappingToUserResponse(UserModel user) {
        return new CreateUserResponseDto(
                // add this to retrieve user_id in response when creating a user
                // user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone()
                //user.getUserRegisterDate()
        );
    }

    public static UserResponseDto mappingToUserListResponse(UserModel user) {
        return new UserResponseDto(
                user.getId(),
                user.getCpf(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getUserRegisterDate()
        );
    }

    public static UserModel mappingToAllUserEntity(AllUserDto userDto) {
        return new UserModel(
                userDto.getCpf(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getUserRegisterDate()
        );
    }

    public static List<UserResponseDto> mappingToUserReponseList(List<UserModel> users){
        return users.stream()
                .map(UserMapper::mappingToUserListResponse)
                .collect(Collectors.toList());
    }





}
