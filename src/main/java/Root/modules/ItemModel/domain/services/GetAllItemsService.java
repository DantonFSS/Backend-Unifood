package Root.modules.ItemModel.domain.services;

import Root.modules.ItemModel.database.entity.ItemModel;
import Root.modules.ItemModel.database.repository.ItemRepository;
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
