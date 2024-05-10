package ShoeStore.ShoeStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Entity.Parameter.Ciudad;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Parameter.ICiudadRepository;
import ShoeStore.ShoeStore.IService.Parameter.ICiudadService;
@Service
public class CiudadService extends ABaseService< Ciudad> implements ICiudadService {

	@Override
	protected IBaseRepository<Ciudad, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	@Autowired
	public ICiudadRepository repository;

	
}
