package Root.modules.items.infra.http.controller;

import Root.modules.items.domain.services.CreateItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
public class CreateItemController {

    private final CreateItemService iServ;

    //@PostMapping("/create")

}
