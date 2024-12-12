
package IFG.Class;

public class Raca {
    private Long id;
    private String nome;
    private String descricao;
    private Tipo tipo;  

    public Raca(Long id, String nome, String descricao, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Raca() {

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getTipoN() {
        if (tipo != null) {
            return tipo.getNome();
        } else {
            return "Sem tipo"; 
        }
    }
    

    public void printRaca() {
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
        if (this.tipo != null) {
            System.out.print(" Tipo: " + this.tipo.getNome());
        }
    }
}