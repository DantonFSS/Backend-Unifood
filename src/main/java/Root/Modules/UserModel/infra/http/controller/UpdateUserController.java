package Root.Modules.UserModel.infra.http.controller;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.domain.services.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UpdateUserController {

    private final UpdateUserService uServ;

    @PutMapping("/update/{cpf}")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel, @PathVariable String cpf) {
        UserModel savedUser = uServ.update(cpf, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
