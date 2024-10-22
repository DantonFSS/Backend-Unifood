package Root.modules.UserModel.infra.http.controller;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.services.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class DeleteUserController {

    private final DeleteUserService uServ;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel> delete(@PathVariable UUID id) {
        uServ.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
