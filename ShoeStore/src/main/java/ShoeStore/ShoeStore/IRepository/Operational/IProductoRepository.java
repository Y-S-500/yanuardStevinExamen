package ShoeStore.ShoeStore.IRepository.Operational;



import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import ShoeStore.ShoeStore.Entity.Operational.Producto;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IProductoRepository extends IBaseRepository<Producto,Long>{

	
	

	@Query(value = "SELECT * FROM productos WHERE "
		    + "(LOWER(nombre_producto) LIKE CONCAT('%', LOWER(:nombre), '%')) AND "
		    + "(LOWER(state) LIKE CONCAT('%', LOWER(:estado), '%'))",
		    nativeQuery = true)
		List<Producto> getNombreFilter(@Param("nombre") String nombre,
		                        @Param("estado") String estado);

	


	



}
