package ShoeStore.ShoeStore.IRepository.Operational;


import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente,Long>{

}
