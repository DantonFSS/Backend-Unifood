package Root.modules.AddressModel.domain.service;

import Root.modules.AddressModel.database.entity.AddressModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    AddressModel searchCep(@PathVariable("cep") String cep);

}

