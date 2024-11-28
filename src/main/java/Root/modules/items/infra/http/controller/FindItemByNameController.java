package Root.modules.items.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.services.FindItemByName;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Items", description = "Manage items - Create, Delete, Read and Update any item.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
@CrossOrigin(origins = "*")
public class FindItemByNameController {

    private final FindItemByName iServ;

    @GetMapping("/{name}")
    public ResponseEntity<ItemModel> findByName(@PathVariable @Valid String name) {
        return ResponseEntity.status(HttpStatus.OK).body(iServ.searchForName(name));
    }
}
