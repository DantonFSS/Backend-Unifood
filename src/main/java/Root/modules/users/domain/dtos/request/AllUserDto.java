package Root.modules.users.domain.dtos.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class AllUserDto {

    @NotNull
    @NotBlank(message = "Cpf must not be empty or null...")
    //@Pattern(regexp = "^\\d{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotNull
    @NotBlank(message = "Name must not be empty or null...")
    @Size(min = 3, max = 200)
    private String name;

    @Email
    @NotNull
    @NotBlank(message = "Email must no be empty or null...")
    private String email;

    private String phone;

    @JsonIgnore
    private final LocalDateTime userRegisterDate = LocalDateTime.now();


}
