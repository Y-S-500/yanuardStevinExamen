package ShoeStore.ShoeStore.IService.Operational;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import ShoeStore.ShoeStore.Dto.IDasboardDto;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IService.IBaseService;

public interface IVentaService extends IBaseService<Venta>{


	List<Venta> getDateFilter(Date fecha) throws Exception;
	List<Venta> getNombre(String nombre)throws Exception;
	List<Venta> getDateRangeFilter(Date fechaInicio, Date fechaFin);
	List<Venta> filtrarVentas(String cliente, Date fechaInicio, Date fechaFin) throws Exception;
	Optional<IDasboardDto> getData();

}
