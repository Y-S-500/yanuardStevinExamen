package ShoeStore.ShoeStore.Service;

import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.IService.Parameter.IEnumService;
import ShoeStore.ShoeStore.utils.Nomenclature;
import ShoeStore.ShoeStore.utils.TypeDocument;


@Service
public class EnumService implements IEnumService{

	

	@Override
	public Nomenclature[] getDirections() {
		// TODO Auto-generated method stub
		return Nomenclature.values();
	}

	@Override
	public TypeDocument[] getTdocuments() {
		// TODO Auto-generated method stub
		return TypeDocument.values();
	}

}