package Root.Modules.UserModel.infra.http.controller;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.domain.services.FindUserByEmailService;
import Root.Modules.UserModel.domain.services.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class GetAllUsersController {

    private final GetAllUsersService uServ;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> findAllUsers(){
        return ResponseEntity.ok(uServ.getAll());
    }
}
