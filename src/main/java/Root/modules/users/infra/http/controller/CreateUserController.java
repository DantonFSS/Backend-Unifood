package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.request.CreateUserDto;
import Root.modules.users.domain.dtos.response.CreateUserResponseDto;
import Root.modules.users.domain.dtos.mappers.UserMapper;
import Root.modules.users.domain.services.InsertUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class CreateUserController {

    private final InsertUserService uServ;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponseDto> registerUser(@Valid @RequestBody CreateUserDto userDTO) {
        UserModel userToCreate = uServ.saveUser(UserMapper.mappingToUserEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mappingToUserResponse(userToCreate));
    }
}
