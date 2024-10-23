package Root.modules.address.database.repository;

import Root.modules.address.database.entity.AddressModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<AddressModel, String> {

}
