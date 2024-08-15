package IFG.Class;

public class Doacao {
    private Long id;
    private String estado;
    private String descricao;
    private String datadoa;
    private String datarec;
    private Animal animal;
    private Pessoa pessoa;

    // Construtor
    public Doacao(Long id, String estado, String descricao, String datadoa, String datarec, Animal animal, Pessoa pessoa) {
        this.id = id;
        this.estado = estado;
        this.descricao = descricao;
        this.datadoa = datadoa;
        this.datarec = datarec;
        this.animal = animal;
        this.pessoa = pessoa;
    }

    public Doacao() {
		
	}

	// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatadoa() {
        return datadoa;
    }

    public void setDatadoa(String datadoa) {
        this.datadoa = datadoa;
    }

    public String getDatarec() {
        return datarec;
    }

    public void setDatarec(String datarec) {
        this.datarec = datarec;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void printDoacao() {
        System.out.println("ID: " + this.id);
        System.out.println("Estado: " + this.estado);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Data da Doação: " + this.datadoa);
        System.out.println("Data de Recebimento: " + this.datarec);
        System.out.println("Nome do Animal: " + this.animal.getNome());
        System.out.println("ID do Animal: " + this.animal.getId());
        System.out.println("Nome do Doador: " + this.animal.getPessoa().getNome());
        System.out.println("ID do Doador: " + this.animal.getPessoa().getId());
        System.out.println("Nome do Donatário: " + this.pessoa.getNome());
        System.out.println("ID do Donatário: " + this.pessoa.getId());
        
    }
}
