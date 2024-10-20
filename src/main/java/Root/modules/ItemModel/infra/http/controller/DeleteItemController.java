package Root.modules.ItemModel.infra.http.controller;

import Root.modules.ItemModel.database.entity.ItemModel;
import Root.modules.ItemModel.domain.services.DeleteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class DeleteItemController {

    private final DeleteItemService iServ;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ItemModel> delete(@PathVariable UUID id) {
        iServ.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
