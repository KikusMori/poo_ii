
    package IFG.DAOs.iDAO;


    import IFG.Class.Raca;

	import java.util.List;
	import java.util.Optional;

    public interface iRacaDAO {
    	Raca saverac(Raca raca);
        Raca updaterac(Raca raca);
        void deleterac(Long id);
        Optional<Raca> findByIdrac(Long id);
        Optional<Raca> findByNorac(String nome);
        List<Raca> findAllrac();

    }