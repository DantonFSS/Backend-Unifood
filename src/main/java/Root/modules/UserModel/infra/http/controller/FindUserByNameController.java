package Root.modules.UserModel.infra.http.controller;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.domain.services.FindUserByName;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class FindUserByNameController {

    private final FindUserByName uServ;

    @GetMapping("/{name}")
    public ResponseEntity<UserModel> findByName(@PathVariable @Valid String name) {
        UserModel user = uServ.searchForName(name);
        return ResponseEntity.ok(user);
    }
}
