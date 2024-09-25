package Root.Modules.UserModel.database.repository;

import Root.Modules.UserModel.database.entity.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {
    UserModel findUserByName(String name);
    UserModel findByEmail(String email);
    UserModel findByCpf(String cpf);
}
