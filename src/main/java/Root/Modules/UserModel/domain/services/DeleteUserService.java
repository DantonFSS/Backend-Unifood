package Root.modules.UserModel.domain.services;

import Root.modules.UserModel.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository uRepo;

    public void deleteUser(UUID id) {
        uRepo.deleteById(id);
    }
}
