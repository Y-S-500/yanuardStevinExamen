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

	
	@Query(value = "SELECT * FROM shoestore.productos as p " +
            "WHERE (:nombre IS NULL OR p.nombre_producto = :nombre) " +
            "AND (:sta IS NULL OR p.state = :sta)",
    nativeQuery = true)
List<Producto> getNombre(@Param("nombre") String nombre,
                       @Param("sta") Integer sta);


	



}
