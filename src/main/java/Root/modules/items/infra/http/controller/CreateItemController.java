package Root.modules.items.infra.http.controller;

import Root.modules.items.domain.services.CreateItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Items", description = "Manage items - Create, Delete, Read and Update any item.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class CreateItemController {

    private final CreateItemService iServ;

    //@PostMapping("/create")

}
