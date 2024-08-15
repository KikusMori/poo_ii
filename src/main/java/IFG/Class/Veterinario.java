package IFG.Class;

public class Veterinario {
    private Long id;
    private String nome;
    private String certificacao;
    private String local;
    private String especialidade;


    public Veterinario(Long id, String nome, String certificacao, String local, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.local = local;
        this.certificacao = certificacao;
        this.especialidade = especialidade;
        
    }


	public Veterinario() {
		
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
    

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCerti() {
        return certificacao;
    }

    public void setCerti(String certificacao) {
        this.certificacao = certificacao;
    }

    public String getEsp() {
        return especialidade;
    }

    public void setEsp(String especialidade) {
        this.especialidade = especialidade;
    }


    public void printVeterinario() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Certificação: " + this.certificacao);
        System.out.println("Local: " + this.local);
        System.out.println("Especialidade: " + this.especialidade);
        
    }
}
