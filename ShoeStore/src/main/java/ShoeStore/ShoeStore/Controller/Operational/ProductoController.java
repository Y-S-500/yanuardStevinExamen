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
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IService.Operational.IProductoService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/productos")
public class ProductoController extends ABaseController<Producto,IProductoService>{

	protected ProductoController(IProductoService service) {
		super(service, "Producto");
	}
	@GetMapping("/filters/{nombre}")
	public ResponseEntity<ApiResponseDto<List<Producto>>> show(@PathVariable String nombre) {
	    try {
	        List<Producto> entity = service.getNombre(nombre);
	        return ResponseEntity.ok(new ApiResponseDto<List<Producto>>("Registro encontrado", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Producto>>(e.getMessage(), null, false));
	    }
	}
	
	@GetMapping("/filters/{state}")
	public ResponseEntity<ApiResponseDto<List<Producto>>> shocw(@PathVariable Long state) {
	    try {
	        List<Producto> entity = service.getStates(state);
	        return ResponseEntity.ok(new ApiResponseDto<List<Producto>>("Registro encontrado", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Producto>>(e.getMessage(), null, false));
	    }
	}
	
	

	
}