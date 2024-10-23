package Root.modules.items.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.services.FindItemByName;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class FindItemByNameController {

    private final FindItemByName iServ;

    @GetMapping("/{name}")
    public ResponseEntity<ItemModel> findByName(@PathVariable @Valid String name) {
        return ResponseEntity.status(HttpStatus.OK).body(iServ.searchForName(name));
    }
}
