package Root.modules.items.infra.http.controller;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.dtos.mappers.ItemMapper;
import Root.modules.items.domain.dtos.request.CreateItemDto;
import Root.modules.items.domain.dtos.response.CreateItemResponseDto;
import Root.modules.items.domain.dtos.response.ItemResponseDto;
import Root.modules.items.domain.services.CreateItemService;
import Root.shared.common.utils.exceptions.httpex.ApplicationError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
public class CreateItemController {

    private final CreateItemService iServ;
    @Operation(
            summary = "Create a new item",
            description = "Resource for create a new item",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Data for creating a item",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    name = "Exemplo de Requisição",
                                    value = """
                    {
                        "name": "Hamburger",
                        "price": "1200",
                        "description": "This is an old recipe of my grandpa",
                        "url": "https://vitarella.com.br/wp-content/uploads/2020/12/08_LASANHA_FINAL-1-min.jpg"
                    }
                    """
                            )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Item create successfully.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ItemResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid field inserted.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApplicationError.class))),
            })
    @PostMapping("/create")
    public ResponseEntity<CreateItemResponseDto> registerItem(@Valid @RequestBody CreateItemDto itemDto) {
        ItemModel itemToCreate = iServ.saveItem(ItemMapper.mappingToItemEntity(itemDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ItemMapper.mappingToItemResponse(itemToCreate));
    }

}
