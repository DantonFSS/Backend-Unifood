package Root.Modules.UserModel.database.entity.dtos;

import Root.Modules.UserModel.database.entity.UserModel;

public record UserResponseDTO(String name) {
    public UserResponseDTO(String name) {
        this.name = name;
    }
}
