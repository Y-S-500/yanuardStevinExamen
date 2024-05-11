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

	@Query(value = "SELECT * \r\n"
	        + "FROM clientes \r\n"
	        + "WHERE \r\n"
	        + "    (LOWER(nombre_cliente) LIKE LOWER(CONCAT('%', :nombre, '%'))) AND\r\n"
	        + "    (LOWER(ciudad) LIKE LOWER(CONCAT('%', :ciudad, '%')))",
            nativeQuery = true)
    List<Cliente> getNombre(@Param("nombre") String nombre,
                            @Param("ciudad") String ciudad
                            );
	
}
	

