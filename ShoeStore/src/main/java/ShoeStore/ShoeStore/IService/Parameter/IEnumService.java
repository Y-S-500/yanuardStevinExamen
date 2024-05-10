package ShoeStore.ShoeStore.IService.Parameter;

import ShoeStore.ShoeStore.utils.Nomenclature;
import ShoeStore.ShoeStore.utils.TypeDocument;

public interface IEnumService {
	Nomenclature[] getDirections();
	
	TypeDocument[] getTdocuments();
}
