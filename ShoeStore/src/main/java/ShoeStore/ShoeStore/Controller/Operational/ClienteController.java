package ShoeStore.ShoeStore.Controller.Operational;



import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IService.Operational.IClienteService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Clientes")
public class ClienteController extends ABaseController<Cliente,IClienteService>{

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
	}
	
	
	

}
