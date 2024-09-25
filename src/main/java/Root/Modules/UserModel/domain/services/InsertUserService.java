package Root.Modules.UserModel.domain.services;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.database.repository.UserRepository;
import Root.Modules.UserModel.domain.exceptions.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertUserService {

    private final UserRepository uRepo;


    public UserModel saveUser(UserModel userModel) {
        if (userModel.getCpf() == null || userModel.getCpf().isBlank()) {
            throw new UserNullCpfException("");
        }
        if (!userModel.getCpf().matches("^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$")) {
            throw new CpfDoNotMatchesException("");
        }
        if (uRepo.findByCpf(userModel.getCpf()) != null) {
            throw new CpfAlreadyExistsException("");
        }
        if (uRepo.findByEmail(userModel.getEmail()) != null) {
            throw new EmailAlreadyUsedException("");
        }
        if (uRepo.findUserByName(userModel.getName()) != null) {
            throw new UserAlreadyExists();
        }
        return uRepo.save(userModel);
    }
}
