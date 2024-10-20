package Root.modules.UserModel.domain.services;

import Root.exceptions.HttpBadRequestException;
import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.database.repository.UserRepository;
import Root.shared.common.utils.consts.UserErrorConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertUserService {

    private final UserRepository uRepo;


    public UserModel saveUser(UserModel userModel) {
        if (!userModel.getCpf().matches("^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$")) {
            throw new HttpBadRequestException(UserErrorConstants.CPF_DOES_NOT_MATCH);
        }
        if (uRepo.findByCpf(userModel.getCpf()) != null) {
            throw new HttpBadRequestException(UserErrorConstants.CPF_ALREADY_EXISTS);
        }
        if (uRepo.findByEmail(userModel.getEmail()) != null) {
            throw new HttpBadRequestException(UserErrorConstants.EMAIL_ALREADY_EXISTS);
        }
        if (uRepo.findUserByName(userModel.getName()) != null) {
            throw new HttpBadRequestException(UserErrorConstants.USER_ALREADY_EXISTS);
        }
        return uRepo.save(userModel);
    }
}
