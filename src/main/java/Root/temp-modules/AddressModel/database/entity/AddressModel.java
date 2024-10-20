package Root.modules.AddressModel.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AddressModel {

    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String complemento;
    private String localidade;
    private String uf;
    private String ddd;

    public AddressModel() {
    }

}
