package ShoeStore.ShoeStore.IService.Operational;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IService.IBaseService;

public interface IClienteService extends IBaseService<Cliente>{

	List<Cliente> getNombre(String nombre, String ciudad, Integer sta)throws Exception;
}
