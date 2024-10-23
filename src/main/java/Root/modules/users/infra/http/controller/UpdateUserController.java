package Root.modules.users.infra.http.controller;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.domain.services.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UpdateUserController {

    private final UpdateUserService uServ;

    @PutMapping("/update/{cpf}")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel, @PathVariable UUID id) {
        UserModel savedUser = uServ.update(id, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
