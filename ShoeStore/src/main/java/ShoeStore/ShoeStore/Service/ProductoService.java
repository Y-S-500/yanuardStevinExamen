package ShoeStore.ShoeStore.Service;

import java.util.List;
import java.util.Optional;

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
	public List<Producto> getNombre(String nombre) {
		// TODO Auto-generated method stub
		return repository.getNombre(nombre);
	}

	@Override
	public List<Producto> getStates(Long state) {
		// TODO Auto-generated method stub
		return repository.getState(state);
	}

}
