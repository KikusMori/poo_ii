package IFG.DAOs.iDAO;

import IFG.Class.Doacao;


import java.util.List;
import java.util.Optional;

public interface iDoacaoDAO {
    Doacao savedoa(Doacao doacao);
    void updatedoa(Doacao doacao);
    void deletedoa(Long id);
    Optional<Doacao> findByIddoa(Long id);
    List<Doacao> findAlldoa();
    
 


}