package Root.modules.items.domain.services;

import Root.modules.items.database.entity.ItemModel;
import Root.modules.items.database.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindItemById {

    private final ItemRepository iRepo;

    public ItemModel findByEmail(UUID id) {
        return iRepo.findById(id).get();
    }
}
