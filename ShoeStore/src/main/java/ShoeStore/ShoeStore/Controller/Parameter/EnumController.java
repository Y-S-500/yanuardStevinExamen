package ShoeStore.ShoeStore.Controller.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.IService.Parameter.IEnumService;
import ShoeStore.ShoeStore.utils.Nomenclature;

import ShoeStore.ShoeStore.utils.TypeDocument;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/enum")
public class EnumController {
	
	@Autowired
	private IEnumService service;
	
	@GetMapping("/nomenclature")
    public Nomenclature[] getDirections() {
        return service.getDirections();
    }
	
	
	@GetMapping("/type-document")
    public TypeDocument[] getTdocument() {
        return service.getTdocuments();
    }
}
