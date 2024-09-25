package Root.Modules.UserModel.domain.services;

import Root.Modules.UserModel.database.entity.UserModel;
import Root.Modules.UserModel.database.repository.UserRepository;
import Root.Modules.UserModel.domain.exceptions.CpfDoNotMatchesException;
import Root.Modules.UserModel.domain.exceptions.UserNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository uRepo;

    public void deleteUser(String cpf) {
        if (uRepo.findByCpf(cpf) == null || cpf.isBlank()) {
            throw new UserNotFound("");
        }
        if (!cpf.matches("^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$") && !cpf.matches(cpf)) {
            throw new CpfDoNotMatchesException("");
        }
        uRepo.deleteById(cpf);
    }
}
