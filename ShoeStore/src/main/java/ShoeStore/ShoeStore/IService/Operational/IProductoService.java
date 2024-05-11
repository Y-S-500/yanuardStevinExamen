package ShoeStore.ShoeStore.IService.Operational;



import java.util.List;
import java.util.Optional;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IService.IBaseService;


public interface IProductoService extends IBaseService<Producto>{

	List<Producto> getNombre(String nombre);

	List<Producto> getStates(Long state);
	
	


}
