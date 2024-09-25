package Root.Modules.AddressModel.database.repository;

import Root.Modules.AddressModel.database.entity.AddressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<AddressModel, String> {

}
