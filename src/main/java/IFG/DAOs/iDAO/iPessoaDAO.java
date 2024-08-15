package IFG.DAOs.iDAO;

import IFG.Class.Pessoa;


import java.util.List;
import java.util.Optional;

public interface iPessoaDAO {
    Pessoa savepes(Pessoa pessoa);
    void updatepes(Pessoa pessoa);
    void deletepes(Long id);
    Optional<Pessoa> findByIdpes(Long id);
    Optional<Pessoa> findByEmpes(String email);
    List<Pessoa> findAllpes();
    
 


}