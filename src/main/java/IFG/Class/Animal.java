package IFG.Class;

public class Animal {
    private Long id;
    private String nome;
    private String datanasc;
    private String foto;
    private boolean doado;
    private int idade;
    private Pessoa pessoa;
    private Raca raca;  

    // Construtor
    public Animal(Long id, String nome, String datanasc, String foto, boolean doado, int idade, Pessoa pessoa, Raca raca) {
        this.id = id;
        this.nome = nome;
        this.datanasc = datanasc;
        this.foto = foto;
        this.doado = doado;
        this.idade = idade;
        this.pessoa = pessoa;
        this.raca = raca;
    }

    public Animal() {
		
	}

	// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public boolean getDoado() {
        return doado;
    }

    public void setDoado(boolean doado) {
        this.doado = doado;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }


    public void printAnimal() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " + this.datanasc);
        System.out.println("Foto: " + this.foto);
        System.out.println("Doado: " + this.doado);
        System.out.println("Idade: " + this.idade);
        System.out.println("Raça: " + this.raca.getNome());
    }
}
