package ShoeStore.ShoeStore.IRepository.Operational;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IProductoRepository extends IBaseRepository<Producto,Long>{

	
	
	@Query(value = "SELECT * FROM shoestore.productos\r\n"
			+ "where productos.nombre_producto = :nombre",
    nativeQuery = true)
List<Producto> getNombre(@Param("nombre") String nombre);

	
	@Query(value = "SELECT * FROM shoestore.productos\r\n"
			+ "where productos.nombre_producto = :state",
    nativeQuery = true)
	List<Producto> getState(@Param("state") Long state);


	



}
