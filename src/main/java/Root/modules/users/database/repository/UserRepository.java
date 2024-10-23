package Root.modules.users.database.repository;

import Root.modules.users.database.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findUserByName(String name);
    UserModel findByEmail(String email);
    UserModel findByCpf(String cpf);
}
