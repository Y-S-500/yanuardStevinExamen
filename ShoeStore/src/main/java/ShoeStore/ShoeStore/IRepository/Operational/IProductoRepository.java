package ShoeStore.ShoeStore.IRepository.Operational;



import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IProductoRepository extends IBaseRepository<Producto,Long>{
	



}
