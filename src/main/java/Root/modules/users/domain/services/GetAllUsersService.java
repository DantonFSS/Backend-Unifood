package Root.modules.users.domain.services;

import Root.modules.users.database.entity.UserModel;
import Root.modules.users.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersService {

    private final UserRepository uRepo;

    public List<UserModel> execute() {
        return uRepo.findAll();
    }
}
