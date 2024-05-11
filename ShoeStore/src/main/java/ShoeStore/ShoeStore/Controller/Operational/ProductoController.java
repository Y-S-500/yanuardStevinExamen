package ShoeStore.ShoeStore.Controller.Operational;



import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Dto.ApiResponseDto;
import ShoeStore.ShoeStore.Dto.ProductoDto;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IService.Operational.IProductoService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/productos")
public class ProductoController extends ABaseController<Producto,IProductoService>{

	protected ProductoController(IProductoService service) {
		super(service, "Producto");
	}
	@PostMapping("/folesd/filter")
    public ResponseEntity<ApiResponseDto<List<Producto>>> filter(@RequestBody ProductoDto filtro) {
        try {
        	System.out.println(filtro.getNombre());
        	System.out.println(filtro.getEstado());
            return ResponseEntity.ok(new ApiResponseDto<List<Producto>>("Datos obtenidos", service.getNombres(filtro.getNombre(), filtro.getEstado()) , true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Producto>>(e.getMessage(), null, false));
        }
    }


	

	
}
