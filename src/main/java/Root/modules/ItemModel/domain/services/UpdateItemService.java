package Root.modules.ItemModel.domain.services;

import Root.modules.ItemModel.database.entity.ItemModel;
import Root.modules.ItemModel.database.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateItemService {

    private final ItemRepository iRepo;

    public ItemModel update(UUID id, ItemModel item) {
        return iRepo.save(item);
    }
}