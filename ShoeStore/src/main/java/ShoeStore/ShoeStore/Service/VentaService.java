package ShoeStore.ShoeStore.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoeStore.ShoeStore.Dto.IDasboardDto;
import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IRepository.Operational.IVentaRepository;
import ShoeStore.ShoeStore.IService.Operational.IVentaService;

@Service
public class VentaService extends ABaseService<Venta> implements IVentaService{

	@Override
	protected IBaseRepository<Venta, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Autowired
	public IVentaRepository repository;

	
	@Override
	public List<Venta> getDateFilter(java.sql.Date fecha) throws Exception {
	    LocalDate localDate = fecha.toLocalDate();
	    int year = localDate.getYear();
	    int month = localDate.getMonthValue();
	    int day = localDate.getDayOfMonth();
	    
	    System.out.print(year);
	    System.out.print(month);
	    System.out.print(day);
	     
	    return repository.getDateFilter(year, month, day);
	}


	@Override
	public List<Venta> getNombre(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return repository.getNombre(nombre);
	}


	@Override
	public List<Venta> getDateRangeFilter(Date fechaInicio, Date fechaFin) {
		return repository.getDateRangeFilter(fechaInicio, fechaFin);
	}

	@Override
	public List<Venta> filtrarVentas(String cliente, java.sql.Date fechaInicio, java.sql.Date fechaFin) throws Exception {
		
		System.out.println(fechaFin);
	    return repository.filtrarVentas(cliente, fechaInicio, fechaFin);
	}


	@Override
	public Optional<IDasboardDto> getData() {
		// TODO Auto-generated method stub
		return repository.getData();
	}

	

}
