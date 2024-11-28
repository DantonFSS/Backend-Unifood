package Root.modules.items.domain.services;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.database.repository.ItemRepository;
import Root.shared.common.utils.consts.ItemErrorConstants;
import Root.shared.common.utils.exceptions.HttpBadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateItemService {

    private final ItemRepository iRepo;

    public ItemModel saveItem(ItemModel item) {
        return iRepo.save(item);
    }

}
