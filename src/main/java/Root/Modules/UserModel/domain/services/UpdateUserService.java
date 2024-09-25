package Root.Modules.UserModel.domain.services;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.database.repository.UserRepository;
import Root.Modules.UserModel.domain.exceptions.CpfDoNotMatchesException;
import Root.Modules.UserModel.domain.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserRepository uRepo;


    public UserModel update(String cpf, UserModel user) {
        if (user.getCpf() == null || cpf.isEmpty()) {
            throw new UserNotFound("");
        }
        if (!cpf.matches("^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$")) {
            throw new CpfDoNotMatchesException("");
        }
        return uRepo.save(user);
    }
}
