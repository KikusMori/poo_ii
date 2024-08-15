package IFG.DAOs.iDAO;

import IFG.Class.Consulta;


import java.util.List;
import java.util.Optional;

public interface iConsultaDAO {
    Consulta savecon(Consulta consulta);
    void updatecon(Consulta consulta);
    void deletecon(Long id);
    Optional<Consulta> findByIdcon(Long id);
    List<Consulta> findAllcon();
    
 


}