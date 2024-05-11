package ShoeStore.ShoeStore.Controller.Operational;



import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Dto.ApiResponseDto;
import ShoeStore.ShoeStore.Dto.FiltroClienteDto;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IService.Operational.IClienteService;



@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/Clientes")
public class ClienteController extends ABaseController<Cliente,IClienteService>{

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
	}
	

	
	@PostMapping("/folesd")
	    public ResponseEntity<ApiResponseDto<List<Cliente>>> filtess(@RequestBody FiltroClienteDto filtro) {
	        try {
	            return ResponseEntity.ok(new ApiResponseDto<List<Cliente>>("Datos obtenidos", service.getNombre(filtro.getNombre(), filtro.getCiudad()) , true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Cliente>>(e.getMessage(), null, false));
	        }
	    }

	

}
