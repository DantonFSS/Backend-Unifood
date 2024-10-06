package Root.modules.UserModel.infra.http.controller;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.services.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class GetAllUsersController {

    private final GetAllUsersService uServ;

    @GetMapping("/all")
    public ResponseEntity<Iterable<UserModel>> findAllUsers(){
        return ResponseEntity.ok(uServ.getAll());
    }
}
