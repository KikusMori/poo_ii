
    package IFG.DAOs.iDAO;


    import IFG.Class.Tipo;

    import java.util.List;
    import java.util.Optional;

    public interface iTipoDAO {
    	Tipo savetip(Tipo tipo);
        Tipo updatetip(Tipo tipo);
        void deletetip(Long id);
        Optional<Tipo> findByIdtip(Long id);
        Optional<Tipo> findByNotip(String nome);
        List<Tipo> findAlltip();

    }