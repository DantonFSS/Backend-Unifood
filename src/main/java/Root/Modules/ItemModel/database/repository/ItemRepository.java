package Root.modules.ItemModel.database.repository;

import Root.modules.ItemModel.database.entity.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<ItemModel, UUID> {
    ItemModel findItemByName (String name);
}
