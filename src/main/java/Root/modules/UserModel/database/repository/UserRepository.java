package Root.modules.UserModel.database.repository;

import Root.modules.UserModel.database.entity.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<UserModel, UUID> {
    UserModel findUserByName(String name);
    UserModel findByEmail(String email);
    UserModel findByCpf(String cpf);
}
