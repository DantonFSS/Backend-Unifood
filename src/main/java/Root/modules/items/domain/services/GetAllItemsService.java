package Root.modules.items.domain.services;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.database.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllItemsService {

    private final ItemRepository iRepo;

    public Iterable<ItemModel> getAll() {
        return iRepo.findAll();
    }
}
