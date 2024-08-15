package IFG.DAOs.iDAO;

import IFG.Class.Veterinario;


import java.util.List;
import java.util.Optional;

public interface iVeterinarioDAO {
    Veterinario savevet(Veterinario veterinario);
    Veterinario updatevet(Veterinario veterinario);
    void deletevet(Long id);
    Optional<Veterinario> findByIdvet(Long id);
    Optional<Veterinario> findByNovet(String nome);
    List<Veterinario> findAllvet();
    
 


}