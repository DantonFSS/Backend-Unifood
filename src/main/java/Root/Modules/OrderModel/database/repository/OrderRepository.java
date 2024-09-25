package Root.Modules.OrderModel.database.repository;

import Root.Modules.OrderModel.database.entity.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderModel, UUID> {
}
