package IFG.DAOs.iDAO;

import IFG.Class.Animal;


import java.util.List;
import java.util.Optional;

public interface iAnimalDAO {
    void saveani(Animal animal);
    void updateani(Animal animal);
    void deleteani(Long id);
    Optional<Animal> findByIdani(Long id);
    Optional<Animal> findByNani(String nome);
    List<Animal> findAllani();
    
 


}