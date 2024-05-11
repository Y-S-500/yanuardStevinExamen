package ShoeStore.ShoeStore.Controller.Operational;



import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Dto.ApiResponseDto;
import ShoeStore.ShoeStore.Dto.FiltroClienteDto;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IService.Operational.IClienteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Clientes")
public class ClienteController extends ABaseController<Cliente,IClienteService>{

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
	}
	
	@PostMapping("/filters")
	public ResponseEntity<ApiResponseDto<List<Cliente>>> show(@RequestBody FiltroClienteDto filtro) {
	    try {
	        List<Cliente> entity = service.getNombre(filtro.getNombre(), filtro.getCiudad(), filtro.getSta());
	        return ResponseEntity.ok(new ApiResponseDto<List<Cliente>>("Registro encontrado", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Cliente>>(e.getMessage(), null, false));
	    }
	}

	

}
