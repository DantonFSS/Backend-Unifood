package Root.modules.items.domain.services;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.database.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateItemService {

    private final ItemRepository iRepo;

    public ItemModel saveItem(ItemModel item) {
        log.info("Saving item to database: {}", item);
        return iRepo.save(item);
    }

}
