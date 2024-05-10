package ShoeStore.ShoeStore.Controller.Operational;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Entity.Operational.DescripcionVentas;
import ShoeStore.ShoeStore.IService.Operational.IDescripcionVentaService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/DescripcionVentas")
public class DescripcionVentaController extends ABaseController<DescripcionVentas,IDescripcionVentaService>{

	protected DescripcionVentaController(IDescripcionVentaService service) {
		super(service, "DescripcionVentas");
	}

}
