package ShoeStore.ShoeStore.Controller.Operational;



import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IService.Operational.IProductoService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/productos")
public class ProductoController extends ABaseController<Producto,IProductoService>{

	protected ProductoController(IProductoService service) {
		super(service, "Producto");
	}
	

	
}
