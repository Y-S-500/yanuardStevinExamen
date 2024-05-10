package ShoeStore.ShoeStore.Controller.Operational;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IService.Operational.IVentaService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/ventas")
public class VentaController extends ABaseController<Venta,IVentaService>{

	protected VentaController(IVentaService service) {
		super(service, "Venta");
	}

}
