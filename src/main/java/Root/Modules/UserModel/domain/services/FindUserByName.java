package Root.Modules.UserModel.domain.services;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.database.repository.UserRepository;
import Root.Modules.UserModel.domain.exceptions.UserHasNullNameException;
import Root.Modules.UserModel.domain.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByName {

    private final UserRepository uRepo;

    public UserModel searchForName(String name) {
        if (uRepo.findUserByName(name) != null || !name.isBlank()) {
            UserModel user = uRepo.findUserByName(name);
            if (user != null) {
                return user;
            } else {
                throw new UserNotFound("");
            }
        }
        throw new UserHasNullNameException("");
    }
}
