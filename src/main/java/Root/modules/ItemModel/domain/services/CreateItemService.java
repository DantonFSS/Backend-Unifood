package Root.modules.ItemModel.domain.services;

import Root.modules.ItemModel.database.entity.ItemModel;
import Root.modules.ItemModel.database.repository.ItemRepository;
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
