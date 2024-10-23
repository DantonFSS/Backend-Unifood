package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.dtos.response.UserResponseDto;
import Root.modules.users.domain.dtos.mappers.UserMapper;
import Root.modules.users.domain.services.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class GetAllUsersController {

    private final GetAllUsersService uServ;

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> execute(){
        List<UserModel> users = uServ.execute();
        return ResponseEntity.status(HttpStatus.OK).body(UserMapper.mappingToUserReponseList(users));

    }
}
