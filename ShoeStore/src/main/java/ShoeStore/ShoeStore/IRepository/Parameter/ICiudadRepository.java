package ShoeStore.ShoeStore.IRepository.Parameter;

import org.springframework.stereotype.Repository;

import ShoeStore.ShoeStore.Entity.Parameter.Ciudad;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;

@Repository
public interface ICiudadRepository extends IBaseRepository<Ciudad, Long> {

}
