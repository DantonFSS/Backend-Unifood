package Root.Modules.UserModel.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class UserModel {

    @Id
    @NotBlank(message = "O campo CPF não pode estar em branco.")
    @Column(nullable = false, unique = true, length = 14, name = "user_cpf")
    @Pattern(regexp = "^([0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2})$", message = "CPF inválido. O formato esperado é XXX.XXX.XXX-XX.")
    private String cpf;


    @NotBlank(message = "Name cannot be blank.")
    @Column(nullable = false, length = 250, name = "user_name")
    private String name;

    /*
    @ManyToOne
    @JoinColumn(name = "user_address", nullable = false)
    private AddressModel address;
    */

    @Email
    @NotBlank(message = "Name cannot be blank.")
    @Column(length = 260, nullable = false, name = "user_email")
    private String email;

    @Column(nullable = false, name = "birth_date_user")
    private String birthDate;


    /*@Column(name = "register_date_user", nullable = false)
    private Date userRegisterDate;*/

    //private UserRole role;

}
