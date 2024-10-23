package Root.modules.items.database.repository;

import Root.modules.items.database.entity.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemModel, UUID> {
    ItemModel findItemByName (String name);
}
