package Root.Modules.UserModel.domain.services;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllUsersService {

    private final UserRepository uRepo;

    public Iterable<UserModel> getAll() {
        return uRepo.findAll();
    }
}
