package ShoeStore.ShoeStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Operational.IVentaRepository;
import ShoeStore.ShoeStore.IService.Operational.IVentaService;

@Service
public class VentaService extends ABaseService<Venta> implements IVentaService{

	@Override
	protected IBaseRepository<Venta, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	public IVentaRepository repository;
}
