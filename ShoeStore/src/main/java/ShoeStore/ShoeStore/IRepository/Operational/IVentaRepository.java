package ShoeStore.ShoeStore.IRepository.Operational;


import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Dto.IDasboardDto;
import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.Entity.Operational.Venta;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IVentaRepository extends IBaseRepository<Venta,Long>{

	

	@Query(value = "SELECT * FROM ventas " +
            "WHERE YEAR(fecha_venta) = :year " +
            "AND MONTH(fecha_venta) = :month " +
            "AND DAY(fecha_venta) = :day", nativeQuery = true)
List<Venta> getDateFilter(@Param("year") int year, 
                             @Param("month") int month, 
                             @Param("day") int day);

	
	@Query(value = "SELECT * \r\n"
	        + "FROM ventas \r\n"
	        + "WHERE \r\n"
	        + "    (LOWER(nombre_cliente) LIKE LOWER(CONCAT('%', :nombre, '%'))) ",
            nativeQuery = true)
    List<Venta> getNombre(@Param("nombre") String nombre
                          );
	
	
	@Query(value = "SELECT * FROM ventas " +
	        "WHERE fecha_venta BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
	List<Venta> getDateRangeFilter(@Param("fechaInicio") java.sql.Date fechaInicio,
	                                 @Param("fechaFin") java.sql.Date fechaFin);
	
	
	
	
	@Query(value = "SELECT v.* " +
            "FROM ventas AS v " +
            "INNER JOIN clientes AS c ON v.cliente_id = c.id " +
            "WHERE c.nombre_cliente = :cliente " +
            "AND v.fecha_venta BETWEEN :fechaInicio AND :fechaFin",
     nativeQuery = true)
List<Venta> filtrarVentas(@Param("cliente") String cliente,
                       @Param("fechaInicio") java.sql.Date fechaInicio,
                       @Param("fechaFin") java.sql.Date fechaFin);
	
	
	@Query(value = "CALL GetRecordCounts();", nativeQuery = true)
    Optional<IDasboardDto> getData();
	

	
}
