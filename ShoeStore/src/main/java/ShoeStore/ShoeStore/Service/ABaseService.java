package ShoeStore.ShoeStore.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;

import ShoeStore.ShoeStore.Entity.ABaseEntity;
import ShoeStore.ShoeStore.IRepository.IBaseRepository;
import ShoeStore.ShoeStore.IService.IBaseService;


/**
 * Abstract base service providing common CRUD operations for entities.
 * @param <T> The type of entity extending ABaseEntity.
 */
public abstract class ABaseService<T extends ABaseEntity> implements IBaseService<T> {


    protected abstract  IBaseRepository<T, Long> getRepository();
   
    @Override
    public List<T> all() throws Exception {
    	List<T> allItems = getRepository().findAll();
        List<T> nonDeletedItems = new ArrayList<>();

        for (T item : allItems) {
            
                nonDeletedItems.add(item);
            
        }

        return nonDeletedItems;
    }

   
    @Override
    public List<T> findByStateTrue() throws Exception {
        return getRepository().findAll();
    }

   
    @Override
    public Optional<T> findById(Long id) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }   
        return op;
    }

   
    @Override
    public T save(T entity) throws Exception {
        try {
   
            return getRepository().save(entity);
        } catch (Exception e) {
            // Captura la excepción
            throw new Exception("Error al guardar la entidad: " + e.getMessage());
        }
    }

   
    @Override
    public void update(Long id, T entity) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } 

        T entityUpdate = op.get();

        String[] ignoreProperties = { "id" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
       //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        getRepository().save(entityUpdate);
    }

   
    @Override
    public void delete(Long id) throws Exception {
        Optional<T> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        }

        T entityUpdate = op.get();
       
        getRepository().delete(entityUpdate);
    }

    
  
}