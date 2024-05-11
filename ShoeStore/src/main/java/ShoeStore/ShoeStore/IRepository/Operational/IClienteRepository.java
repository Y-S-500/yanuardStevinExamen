package ShoeStore.ShoeStore.IRepository.Operational;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Operational.Cliente;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface IClienteRepository extends IBaseRepository<Cliente,Long>{

	@Query(value = "SELECT * FROM shoestore.clientes " +
            "WHERE (:nombre IS NULL OR clientes.nombre_cliente = :nombre) " +
            "AND (:ciudad IS NULL OR clientes.ciudad = :ciudad) " +
            "AND (:sta IS NULL OR clientes.state = :sta)",
    nativeQuery = true)
List<Cliente> getNombre(@Param("nombre") String nombre,
               @Param("ciudad") String ciudad,
               @Param("sta") Integer sta);

}
