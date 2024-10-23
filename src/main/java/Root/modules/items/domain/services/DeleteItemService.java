package Root.modules.items.domain.services;

import Root.modules.items.database.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteItemService {

    private final ItemRepository iRepo;

    public void deleteItem(UUID id) {
        iRepo.deleteById(id);
    }
}
