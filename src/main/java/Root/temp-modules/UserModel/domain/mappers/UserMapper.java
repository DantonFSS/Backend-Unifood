package Root.modules.UserModel.domain.mappers;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.dtos.request.CreateUserDTO;
import Root.modules.UserModel.domain.dtos.response.UserResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public static UserModel mappingToUserEntity(CreateUserDTO createUserDTO) {
        return new UserModel(
                createUserDTO.getCpf(),
                createUserDTO.getName(),
                createUserDTO.getEmail(),
                LocalDateTime.now()
        );
    }

    public static UserResponseDTO mappingToUserResponse(UserModel user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getUserRegisterDate()
        );
    }
}
