package Root.modules.UserModel.domain.services;

import Root.exceptions.HttpBadRequestException;
import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.database.repository.UserRepository;
import Root.shared.common.utils.consts.UserErrorConstants;
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
                throw new HttpBadRequestException(UserErrorConstants.USER_NOT_FOUND);
            }
        }
        throw new HttpBadRequestException(UserErrorConstants.USER_NAME_NOT_FOUND);
    }
}
