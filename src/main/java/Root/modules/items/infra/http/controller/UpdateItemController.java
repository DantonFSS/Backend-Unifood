package Root.modules.items.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.services.UpdateItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class UpdateItemController {

    private final UpdateItemService iServ;

    @PutMapping("/update/{id}")
    public ResponseEntity<ItemModel> update(@RequestBody ItemModel item, @PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iServ.update(id, item));
    }
}
