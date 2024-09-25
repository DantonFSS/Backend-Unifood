package Root.Modules.UserModel.infra.http.controller;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.domain.services.FindUserByName;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class FindByNameController {

    private final FindUserByName uServ;

    @GetMapping("/{name}")
    public ResponseEntity<UserModel> findByName(@PathVariable @Valid String name) {
        UserModel user = uServ.searchForName(name);
        return ResponseEntity.ok(user);
    }
}
