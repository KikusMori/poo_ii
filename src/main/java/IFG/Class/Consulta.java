package IFG.Class;

public class Consulta {
    private Long id;
    private String diagnostico;
    private String data;
    private Animal animal;
    private Veterinario veterinario;


    public Consulta(Long id, String diagnostico, String data, Animal animal, Veterinario veterinario) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.animal = animal;
        this.data = data;
        this.veterinario = veterinario;
        
    }


	public Consulta() {
		
	}


	// Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Veterinario getVet() {
        return veterinario;
    }

    public void setVet(Veterinario veterinario) {
        this.veterinario = veterinario;
    }


    public void printConsulta() {
        System.out.println("ID: " + this.id);
        System.out.println("Diagnostico: " + this.diagnostico);
        System.out.println("Data: " + this.data);
        System.out.println("Animal: " + this.animal.getNome());
        System.out.println("Veterinario: " + this.veterinario.getNome());
        
    }
}
