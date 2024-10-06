package Root.modules.UserModel.domain.services;

import Root.exceptions.HttpBadRequestException;
import Root.exceptions.HttpNotFoundException;
import Root.modules.UserModel.database.entity.UserModel;
import Root.modules.UserModel.database.repository.UserRepository;
import Root.shared.common.utils.consts.UserErrorConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository uRepo;


    public UserModel update(String cpf, UserModel user) {
        if (user.getCpf() == null || cpf.isEmpty()) {
            throw new HttpNotFoundException(UserErrorConstants.USER_NOT_FOUND);
        }
        if (!cpf.matches("^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$")) {
            throw new HttpBadRequestException(UserErrorConstants.CPF_DOES_NOT_MATCH);
        }
        return uRepo.save(user);
    }
}
