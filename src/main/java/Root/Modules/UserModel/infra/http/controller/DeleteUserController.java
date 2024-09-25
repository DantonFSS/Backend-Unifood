package Root.Modules.UserModel.infra.http.controller;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.domain.services.DeleteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class DeleteUserController {

    private final DeleteUserService uServ;

    @DeleteMapping("/delete/{cpf}")
    public ResponseEntity<UserModel> delete(@PathVariable String cpf) {
        uServ.deleteUser(cpf);
        return ResponseEntity.ok().build();
    }
}
