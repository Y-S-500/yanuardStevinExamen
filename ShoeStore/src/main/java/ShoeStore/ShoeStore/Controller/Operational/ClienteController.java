package ShoeStore.ShoeStore.Controller.Operational;



import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Dto.ApiResponseDto;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IService.Operational.IClienteService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Clientes")
public class ClienteController extends ABaseController<Cliente,IClienteService>{

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
	}
	
	@GetMapping("/filters/{nombre}/{ciudad}/{sta}")
	public ResponseEntity<ApiResponseDto<List<Cliente>>> show(
	        @RequestParam(value = "nombre", required = false) String nombre,
	        @RequestParam(value = "ciudad", required = false) String ciudad,
	        @RequestParam(value = "sta", required = false) Integer sta
	       ) {
	    try {
	        List<Cliente> entity = service.getNombre(nombre, ciudad, sta);
	        return ResponseEntity.ok(new ApiResponseDto<List<Cliente>>("Registro encontrado", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Cliente>>(e.getMessage(), null, false));
	    }
	}
	

}
