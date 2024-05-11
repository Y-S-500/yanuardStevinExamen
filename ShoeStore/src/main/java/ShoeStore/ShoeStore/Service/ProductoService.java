package ShoeStore.ShoeStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Operational.IProductoRepository;
import ShoeStore.ShoeStore.IService.Operational.IProductoService;

@Service
public class ProductoService  extends ABaseService<Producto> implements IProductoService{

	@Override
	protected IBaseRepository<Producto, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public IProductoRepository repository;

	

	



	@Override
	public List<Producto> getNombres(String nombre, String estado) {
		// TODO Auto-generated method stub
		return repository.getNombreFilter(nombre,estado);
	}

}
