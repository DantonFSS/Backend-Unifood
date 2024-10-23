package Root.modules.users.domain.dtos.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserResponseDto {

    //add this to retrieve user_id in response when creating a user private
    // UUID id;
    private String name;
    private String email;
    private String phone;

    //@CreatedDate
    //private LocalDateTime userRegisterDate;

}
