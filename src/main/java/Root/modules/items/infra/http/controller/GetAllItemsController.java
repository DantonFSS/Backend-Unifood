package Root.modules.items.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.services.GetAllItemsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Items", description = "Manage items - Create, Delete, Read and Update any item.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
@CrossOrigin(origins = "*")
public class GetAllItemsController {

    private final GetAllItemsService iServ;

    @GetMapping("/all")
    public ResponseEntity<Iterable<ItemModel>> findAllItems(){
        return ResponseEntity.ok(iServ.getAll());
    }
}
