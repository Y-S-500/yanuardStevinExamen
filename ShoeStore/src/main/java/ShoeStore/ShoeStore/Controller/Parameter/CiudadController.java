package ShoeStore.ShoeStore.Controller.Parameter;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Entity.Parameter.Ciudad;
import ShoeStore.ShoeStore.IService.Parameter.ICiudadService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/Ciudades")
public class CiudadController extends ABaseController<Ciudad,ICiudadService>{

	protected CiudadController(ICiudadService service) {
		super(service, "Ciudad");
		// TODO Auto-generated constructor stub
	}

}
