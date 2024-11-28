package Root.modules.items.domain.dtos.mappers;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.domain.dtos.request.AllItemDto;
import Root.modules.items.domain.dtos.request.CreateItemDto;
import Root.modules.items.domain.dtos.response.CreateItemResponseDto;
import Root.modules.items.domain.dtos.response.ItemResponseDto;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static ItemModel mappingToItemEntity(CreateItemDto createDto) {
        return new ItemModel(
                createDto.getName(),
                createDto.getPrice(),
                createDto.getDescription(),
                createDto.getUrl()
        );
    }

    public static CreateItemResponseDto mappingToItemResponse(ItemModel item) {
        return new CreateItemResponseDto(
                item.getName(),
                item.getPrice(),
                item.getDescription(),
                item.getUrl()
        );
    }

    public static ItemResponseDto mappingToItemListResponse(ItemModel item) {
        return new ItemResponseDto(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getDescription(),
                item.getUrl()
        );
    }

    public static ItemModel mappingToAllItemEntity(AllItemDto itemDto) {
        return new ItemModel(
                itemDto.getName(),
                itemDto.getPrice(),
                itemDto.getDescription()
        );
    }

    public static List<ItemResponseDto> mappingToItemReponseList(List<ItemModel> items){
        return items.stream()
                .map(ItemMapper::mappingToItemListResponse)
                .collect(Collectors.toList());
    }

}
