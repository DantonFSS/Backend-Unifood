package Root.modules.ItemModel.infra.http.controller;

import Root.modules.ItemModel.database.entity.ItemModel;
import Root.modules.ItemModel.domain.services.GetAllItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class GetAllItemsController {

    private final GetAllItemsService iServ;

    @GetMapping("/create")
    public ResponseEntity<Iterable<ItemModel>> findAllItems(){
        return ResponseEntity.ok(iServ.getAll());
    }
}
