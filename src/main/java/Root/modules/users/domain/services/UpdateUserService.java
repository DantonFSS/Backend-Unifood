package Root.modules.users.domain.services;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository uRepo;


    public UserModel update(String cpf, UserModel user) {
        return uRepo.save(user);
    }
}
