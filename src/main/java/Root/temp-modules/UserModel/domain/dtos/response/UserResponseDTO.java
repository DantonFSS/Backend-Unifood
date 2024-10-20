package Root.modules.UserModel.domain.dtos.response;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;

    @CreatedDate
    private LocalDateTime userRegisterDate;

}
