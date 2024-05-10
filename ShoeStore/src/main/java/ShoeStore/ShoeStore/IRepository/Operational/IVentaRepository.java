package ShoeStore.ShoeStore.IRepository.Operational;


import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IVentaRepository extends IBaseRepository<Venta,Long>{

}
