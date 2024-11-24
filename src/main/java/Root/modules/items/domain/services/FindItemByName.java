package Root.modules.items.domain.services;

import Root.shared.common.utils.exceptions.HttpBadRequestException;
import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.database.repository.ItemRepository;
import Root.shared.common.utils.consts.ItemErrorConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindItemByName {

    private final ItemRepository iRepo;

    public ItemModel searchForName(String name) {
        if (iRepo.findItemByName(name) != null || !name.isBlank()) {
            ItemModel item = iRepo.findItemByName(name);
            if (item != null) {
                return item;
            } else {
                throw new HttpBadRequestException(ItemErrorConstants.ITEM_NOT_FOUND);
            }
        }
        throw new HttpBadRequestException(ItemErrorConstants.ITEM_NAME_NOT_FOUND);
    }
}
