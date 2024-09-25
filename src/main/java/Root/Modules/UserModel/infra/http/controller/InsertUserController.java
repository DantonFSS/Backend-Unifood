package Root.Modules.UserModel.infra.http.controller;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.domain.services.InsertUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class InsertUserController {

    private final InsertUserService uServ;

    @PostMapping("/insert")
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel userModel) {
        UserModel savedUser = uServ.saveUser(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
