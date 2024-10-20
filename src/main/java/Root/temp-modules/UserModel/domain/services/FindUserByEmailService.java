package Root.modules.UserModel.domain.services;

import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByEmailService {

    private final UserRepository uRepo;

    public UserModel findByEmail(String email) {
        return uRepo.findByEmail(email);
    }
}
