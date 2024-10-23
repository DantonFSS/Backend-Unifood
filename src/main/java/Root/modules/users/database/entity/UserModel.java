package Root.modules.users.database.entity;

import Root.modules.address.database.entity.AddressModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Table(name = "users")
@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true, name = "id_user")
    private UUID id;

    @Column(nullable = false, unique = true, length = 14, name = "cpf_user")
    private String cpf;

    @Column(nullable = false, length = 250, name = "full_name_user")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_address")
    private AddressModel address;

    @Email
    @Column(nullable = false, name = "user_email")
    private String email;

    @Column(name = "register_date_user", nullable = false, updatable = false)
    private LocalDateTime userRegisterDate;

    //@LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "password_user")
    private String password;

    @Column(name = "phone_user")
    private String phone;

    @Column(name = "birth_date_user")
    private Date birthDateUser;

    @Column(name = "role_user")
    private UserRole role;

    public UserModel(String cpf, String name, String email/*, LocalDateTime userRegisterDate*/) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        //this.userRegisterDate = userRegisterDate;
    }

    public UserModel(String cpf, String name, String email, String phone,LocalDateTime userRegisterDate) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userRegisterDate = userRegisterDate;
    }

    public UserModel(UUID id, String cpf, String name, String email, String phone,LocalDateTime userRegisterDate) {

    }

}
