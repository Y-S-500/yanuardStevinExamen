package ShoeStore.ShoeStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Entity.Operational.DescripcionVentas;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Operational.IDescripcionVentaRepository;
import ShoeStore.ShoeStore.IService.Operational.IDescripcionVentaService;

@Service
public class DescripcionVentaService extends ABaseService< DescripcionVentas> implements IDescripcionVentaService {

	@Override
	protected IBaseRepository<DescripcionVentas, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public IDescripcionVentaRepository repository;

	
}
