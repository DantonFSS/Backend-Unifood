package Root.Modules.UserModel.database.entity.dtos;

import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull
        String name

) {
}
