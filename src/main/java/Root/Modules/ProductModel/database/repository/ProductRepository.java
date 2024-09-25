package Root.Modules.ProductModel.database.repository;

import Root.Modules.ProductModel.database.entity.ProductModel;
import Root.Modules.UserModel.database.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
