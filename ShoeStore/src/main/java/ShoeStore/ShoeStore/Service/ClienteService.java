package ShoeStore.ShoeStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Operational.IClienteRepository;
import ShoeStore.ShoeStore.IService.Operational.IClienteService;


@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService {

	@Override
	protected IBaseRepository<Cliente, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public IClienteRepository repository;

}