package Root.modules.UserModel.infra.http.controller;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.services.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UpdateUserController {

    private final UpdateUserService uServ;

    @PutMapping("/update/{cpf}")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel, @PathVariable String cpf) {
        UserModel savedUser = uServ.update(cpf, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
