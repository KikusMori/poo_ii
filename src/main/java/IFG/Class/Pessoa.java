package IFG.Class;

public class Pessoa {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String datanasc;

 
    public Pessoa() {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.datanasc = datanasc;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return datanasc;
    }

    public void setData(String datanasc) {
        this.datanasc = datanasc;
    }
    

    public void printPessoa() {
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
        System.out.print(" Endereco: " + this.endereco);
        System.out.print(" Telefone: " + this.telefone);
        System.out.print(" Email: " + this.email);
        System.out.print(" Data de Nascimento: " + this.datanasc);


    }
}