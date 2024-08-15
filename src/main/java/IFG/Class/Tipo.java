package IFG.Class;

public class Tipo {
    public class java {

	}


	private Long id;
    private String nome;

    public Tipo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Tipo(String nome) {
        this.id = null;
        this.nome = nome;

    }

    public Tipo() {
        this.id = null;
        this.nome = null;

    }


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


    public void printReino() {
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);



    }
}