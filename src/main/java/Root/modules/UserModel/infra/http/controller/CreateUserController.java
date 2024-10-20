package Root.modules.UserModel.infra.http.controller;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.dtos.request.CreateUserDTO;
import Root.modules.UserModel.domain.dtos.response.UserResponseDTO;
import Root.modules.UserModel.domain.mappers.UserMapper;
import Root.modules.UserModel.domain.services.InsertUserService;
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
    public ResponseEntity<UserResponseDTO> registerUser( @Valid @RequestBody CreateUserDTO userDTO) {
        UserModel userToCreate = uServ.saveUser(UserMapper.mappingToUserEntity(userDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.mappingToUserResponse(userToCreate));
    }
}
