package ShoeStore.ShoeStore.IRepository;

import ShoeStore.ShoeStore.Entity.ABaseEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBaseRepository<T extends ABaseEntity, ID> extends JpaRepository<T, Long>{

	
	

}
