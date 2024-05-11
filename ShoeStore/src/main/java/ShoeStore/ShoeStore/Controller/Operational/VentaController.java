package ShoeStore.ShoeStore.Controller.Operational;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ShoeStore.ShoeStore.Controller.ABaseController;
import ShoeStore.ShoeStore.Dto.ApiResponseDto;
import ShoeStore.ShoeStore.Dto.FiltroVentaDto;
import ShoeStore.ShoeStore.Dto.IDasboardDto;
import ShoeStore.ShoeStore.Dto.ProductoDto;
import ShoeStore.ShoeStore.Dto.dateDto;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IService.Operational.IVentaService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("v1/api/ventas")
public class VentaController extends ABaseController<Venta,IVentaService>{

	protected VentaController(IVentaService service) {
		super(service, "Venta");
	}
	/**
	 * @param fechaString
	 * @return
	 */
//	@GetMapping("/fil/{fechaString}")
//	public ResponseEntity<ApiResponseDto<List<Venta>>> show(@PathVariable String fechaString) {
//	    try {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	        java.sql.Date fecha = new java.sql.Date(dateFormat.parse(fechaString).getTime());
//	        List<Venta> entity = service.getDateFilter(fecha);
//	        return ResponseEntity.ok(new ApiResponseDto<>("Registro encontrado", entity, true));
//	    } catch (Exception e) {
//	        return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
//	    }
//	}
	
	
	@GetMapping("/fil/{fechaInicio}/{fechaFin}")
	public ResponseEntity<ApiResponseDto<List<Venta>>> show(@PathVariable String fechaInicio, @PathVariable String fechaFin) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.sql.Date fechaInicioDate = new java.sql.Date(dateFormat.parse(fechaInicio).getTime());
	        java.sql.Date fechaFinDate = new java.sql.Date(dateFormat.parse(fechaFin).getTime());
	        List<Venta> entity = service.getDateRangeFilter(fechaInicioDate, fechaFinDate);
	        return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
	    }
	}

	
//	
//	@PostMapping("/filterNombre")
//    public ResponseEntity<ApiResponseDto<List<Producto>>> filter(@RequestBody ProductoDto filtro) {
//        try {
//        	System.out.println(filtro.getNombre());
//        	System.out.println(filtro.getEstado());
//            return ResponseEntity.ok(new ApiResponseDto<List<Producto>>("Datos obtenidos", service.getNombres(filtro.getNombre(), filtro.getEstado()) , true));
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<Producto>>(e.getMessage(), null, false));
//        }
//    }
	
	
	@PostMapping("/filtrar/date")
	public ResponseEntity<ApiResponseDto<List<Venta>>> filtrarVentas(@RequestBody FiltroVentaDto filtro) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        java.sql.Date fechaInicioDate = new java.sql.Date(dateFormat.parse(filtro.getFechaInicio()).getTime());
	        java.sql.Date fechaFinDate = new java.sql.Date(dateFormat.parse(filtro.getFechaFin()).getTime());
	        List<Venta> entity = service.filtrarVentas(filtro.getCliente(), fechaInicioDate, fechaFinDate);
	        return ResponseEntity.ok(new ApiResponseDto<>("Registros encontrados", entity, true));
	    } catch (Exception e) {
	        return ResponseEntity.internalServerError().body(new ApiResponseDto<>(e.getMessage(), null, false));
	    }
	}
	  @GetMapping("/dasboard")
	    public ResponseEntity<ApiResponseDto<Optional<IDasboardDto>>> dasboard() {
	        try {
	            return ResponseEntity.ok(new ApiResponseDto<Optional<IDasboardDto>>("Datos obtenidos", service.getData(), true));
	        } catch (Exception e) {
	            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<IDasboardDto>>(e.getMessage(), null, false));
	        }
	    }


	


}
