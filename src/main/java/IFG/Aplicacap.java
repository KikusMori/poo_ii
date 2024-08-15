package IFG;

import IFG.Class.Animal;
import IFG.Class.Consulta;
import IFG.Class.Doacao;
import IFG.Class.Pessoa;
import IFG.Class.Raca;
import IFG.Class.Tipo;
import IFG.Class.Veterinario;
import IFG.DAOs.AnimalDAO;
import IFG.DAOs.ConsultaDAO;
import IFG.DAOs.DoacaoDAO;
import IFG.DAOs.PessoaDAO;
import IFG.DAOs.RacaDAO;
import IFG.DAOs.TipoDAO;
import IFG.DAOs.VeterinarioDAO;

import java.util.Scanner;
import java.util.List;
import java.util.Optional;

public class Aplicacap {
    private static final Integer Logeger = null;
    
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	 System.out.println("Menu:");
         System.out.println("(1) C -> Create");
         System.out.println("(2) R -> Select");
         System.out.println("(3) U -> Update");
         System.out.println("(4) D -> Delete");
         System.out.print("Escolha uma opção: ");
    	String escolha = scanner.nextLine();
    	 switch (escolha) {
         case "1":
	        	 System.out.println("Menu:");
	             System.out.println("(1) Create Animal");
	             System.out.println("(2) Create Consulta");
	             System.out.println("(3) Create Doação");
	             System.out.println("(4) Create Pessoa");
	             System.out.println("(5) Create Raça");
	             System.out.println("(6) Create Tipo");
	             System.out.println("(7) Create Veterinário");
	             System.out.print("Escolha uma opção: ");
	        	 escolha = scanner.nextLine();
	        	 switch (escolha) {
		        	 case "1":
		        		 AnimalDAO animalDAO = new AnimalDAO();
		        		    Animal animal = new Animal();
		        		    String esc;
		        		
		        		    System.out.print("Nome: ");
		        		    esc = scanner.nextLine();
		        		    animal.setNome(esc);
		        		    System.out.print("Data de Nascimento: ");
		        		    esc = scanner.nextLine();
		        		    animal.setDatanasc(esc);
		        		    System.out.print("Foto: ");
		        		    esc = scanner.nextLine();
		        		    animal.setFoto(esc);
		        		    System.out.print("Foi doado? : ");
		        		    esc = scanner.nextLine();
		        		    boolean ddo;
		        		    if (esc.equalsIgnoreCase("sim")) {
		        		        ddo = true;
		        		    } else {
		        		        ddo = false;
		        		    }
		        		    animal.setDoado(ddo);
		        		    System.out.print("Idade: ");
		        		    esc = scanner.nextLine();
		        		    int numero = Integer.parseInt(esc);
		        		    animal.setIdade(numero);
		        		    System.out.print("ID da raça: ");
		        	        esc = scanner.nextLine();
		        	        Long id = Long.parseLong(esc);
		        	        Raca racani = new Raca();
		        	        racani.setId(id);
		        	        animal.setRaca(racani);
		        	        System.out.print("ID do responsável: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Pessoa pesani = new Pessoa();
		        	        pesani.setId(id);
		        	        animal.setPessoa(pesani);
		        		    animalDAO.saveani(animal);
		        		 break;
		        	 case "2":
		        		 ConsultaDAO consultaDAO = new ConsultaDAO();
		        		    Consulta consulta = new Consulta();
		        		  
		        		    System.out.print("Diagnóstico: ");
		        		    esc = scanner.nextLine();
		        		    consulta.setDiagnostico(esc);
		        		    System.out.print("Data: ");
		        		    esc = scanner.nextLine();
		        		    consulta.setData(esc);
		        		
		        		    System.out.print("ID do animal: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Animal conani = new Animal();
		        	        conani.setId(id);
		        	        consulta.setAnimal(conani);
		        	        System.out.print("ID do veterinário: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Veterinario convet  = new Veterinario();
		        	        convet.setId(id);
		        	        consulta.setVet(convet);
		        		    consultaDAO.savecon(consulta);
		        		 break;
		        	 case "3":
		        		 DoacaoDAO doacaoDAO = new DoacaoDAO();
		        		   	Doacao doacao = new Doacao();
		        		
		        		    System.out.print("Estado: ");
		        		    esc = scanner.nextLine();
		        		    doacao.setEstado(esc);
		        		    System.out.print("Descricao: ");
		        		    esc = scanner.nextLine();
		        		    doacao.setDescricao(esc);
		        		    System.out.print("Data de Inicialização: ");
		        		    esc = scanner.nextLine();
		        		    doacao.setDatadoa(esc);
		        		    System.out.print("Data de Finalização: ");
		        		    esc = scanner.nextLine();
		        		    doacao.setDatarec(esc);
		        		
		        		    System.out.print("ID do animal: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Animal doani = new Animal();
		        	        doani.setId(id);
		        	        doacao.setAnimal(doani);
		        	        System.out.print("ID do Donatário: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Pessoa dopes = new Pessoa();
		        	        dopes.setId(id);
		        	        doacao.setPessoa(dopes);
		        		    doacaoDAO.savedoa(doacao);
		        		 break;
		        	 case "4":
		        		    PessoaDAO pessoaDAO = new PessoaDAO();
		        		    Pessoa pessoa = new Pessoa();
		        		   
		        		    System.out.print("Nome: ");
		        		    esc = scanner.nextLine();
		        		    pessoa.setNome(esc);
		        		    System.out.print("Endereço: ");
		        		    esc = scanner.nextLine();
		        		    pessoa.setEndereco(esc);
		        		    System.out.print("Telefone: ");
		        		    esc = scanner.nextLine();
		        		    pessoa.setTelefone(esc);
		        		    System.out.print("Email: ");
		        		    esc = scanner.nextLine();
		        		    pessoa.setEmail(esc);
		        		    System.out.print("Data de Nascimento: ");
		        		    esc = scanner.nextLine();
		        		    pessoa.setData(esc);
		        		    pessoaDAO.savepes(pessoa);
		        		 break;
		        	 case "5":
		        		    RacaDAO racaDAO = new RacaDAO();
		        		    Raca raca = new Raca();
		        		  
		        		    System.out.print("Nome: ");
		        		    esc = scanner.nextLine();
		        		    raca.setNome(esc);
		        		    System.out.print("Descricao: ");
		        		    esc = scanner.nextLine();
		        		    raca.setDescricao(esc);
		        		    System.out.print("ID do tipo: ");
		        	        esc = scanner.nextLine();
		        	        id = Long.parseLong(esc);
		        	        Tipo rati = new Tipo();
		        	        rati.setId(id);
		        	        raca.setTipo(rati);
		        	        racaDAO.saverac(raca);
		        		 break;
		        	 case "6":
		        		 	TipoDAO tipoDAO = new TipoDAO();
		        		    Tipo tipo = new Tipo();
		        		   
		        		    System.out.print("Nome: ");
		        		    esc = scanner.nextLine();
		        		    tipo.setNome(esc);
		        		    tipoDAO.savetip(tipo);
		        		 break;
		        	 case "7":
		        		    VeterinarioDAO vetDAO = new VeterinarioDAO();
		        		    Veterinario veterinario = new Veterinario();
		        		   
		        		    System.out.print("Nome: ");
		        		    esc = scanner.nextLine();
		        		    veterinario.setNome(esc);
		        		    System.out.print("Certificação: ");
		        		    esc = scanner.nextLine();
		        		    veterinario.setCerti(esc);
		        		    System.out.print("Local: ");
		        		    esc = scanner.nextLine();
		        		    veterinario.setLocal(esc);
		        		    System.out.print("Especialização: ");
		        		    esc = scanner.nextLine();
		        		    veterinario.setEsp(esc);	     
		        		    vetDAO.savevet(veterinario);
		        		 break;
	        	 
	        	 default:
	                 System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
	        	 }
	             
             break;
         case "2":
        	System.out.println("Menu:");
     	    System.out.println("(1) Selecionar Animal");
     	    System.out.println("(2) Selecionar Consulta");
     	    System.out.println("(3) Selecionar Doação");
     	    System.out.println("(4) Selecionar Pessoa");
     	    System.out.println("(5) Selecionar Raça");
     	    System.out.println("(6) Selecionar Tipo");
     	    System.out.println("(7) Selecionar Veterinário");
     	    System.out.print("Escolha uma opção: ");
     	    escolha = scanner.nextLine();
     	   
           
     	    switch(escolha) {
	     	   case "1": 
	     		    AnimalDAO animalDAO = new AnimalDAO();
	     		    List<Animal> animals = animalDAO.findAllani();
	     		    
	     		    if (animals.isEmpty()) {
	     		        System.out.println("Nenhum animal encontrado.");
	     		    } else {
	     		        System.out.println("Lista de Animais:");
	     		        for (Animal animal : animals) {
	     		            System.out.println("ID: " + animal.getId());
	     		            System.out.println("Nome: " + animal.getNome());
	     		            System.out.println("Data de Nascimento: " + animal.getDatanasc());
	     		            System.out.println("Foto: " + animal.getFoto());
	     		            System.out.println("Foi doado? " + (animal.getDoado() ? "Sim" : "Não"));
	     		            System.out.println("Idade: " + animal.getIdade());
	     		            System.out.println("ID da Raça: " + animal.getRaca().getId());
	     		            System.out.println("ID do Responsável: " + animal.getPessoa().getId());
	     		            System.out.println("---------------------------");
	     		        }
	     		    }
	     		    break;
	     	  case "2": 
	     		    ConsultaDAO consultaDAO = new ConsultaDAO();
	     		    List<Consulta> consultas = consultaDAO.findAllcon();
	     		    
	     		    if (consultas.isEmpty()) {
	     		        System.out.println("Nenhuma consulta encontrada.");
	     		    } else {
	     		        System.out.println("Lista de Consultas:");
	     		        for (Consulta consulta : consultas) {
	     		            System.out.println("ID: " + consulta.getId());
	     		            System.out.println("Diagnóstico: " + consulta.getDiagnostico());
	     		            System.out.println("Data: " + consulta.getData());
	     		            System.out.println("ID do Animal: " + consulta.getAnimal().getId());
	     		            System.out.println("ID do Veterinário: " + consulta.getVet().getId());
	     		            System.out.println("---------------------------");
	     		        }
	     		    }
	     		    break;
	     	 case "3": 
	     	    DoacaoDAO doacaoDAO = new DoacaoDAO();
	     	    List<Doacao> doacoes = doacaoDAO.findAlldoa();
	     	    
	     	    if (doacoes.isEmpty()) {
	     	        System.out.println("Nenhuma doação encontrada.");
	     	    } else {
	     	        System.out.println("Lista de Doações:");
	     	        for (Doacao doacao : doacoes) {
	     	            System.out.println("ID: " + doacao.getId());
	     	            System.out.println("Estado: " + doacao.getEstado());
	     	            System.out.println("Descrição: " + doacao.getDescricao());
	     	            System.out.println("Data de Inicialização: " + doacao.getDatadoa());
	     	            System.out.println("Data de Finalização: " + doacao.getDatarec());
	     	            System.out.println("ID do Animal: " + (doacao.getAnimal() != null ? doacao.getAnimal().getId() : "Não definido"));
	     	            System.out.println("ID do Donatário: " + (doacao.getPessoa() != null ? doacao.getPessoa().getId() : "Não definido"));
	     	            System.out.println("---------------------------");
	     	        }
	     	    }
	     	    break;

	     	case "4": 
	     	    PessoaDAO pessoaDAO = new PessoaDAO();
	     	    List<Pessoa> pessoas = pessoaDAO.findAllpes();
	     	    
	     	    if (pessoas.isEmpty()) {
	     	        System.out.println("Nenhuma pessoa encontrada.");
	     	    } else {
	     	        System.out.println("Lista de Pessoas:");
	     	        for (Pessoa pessoa : pessoas) {
	     	            System.out.println("ID: " + pessoa.getId());
	     	            System.out.println("Nome: " + pessoa.getNome());
	     	            System.out.println("Endereço: " + pessoa.getEndereco());
	     	            System.out.println("Telefone: " + pessoa.getTelefone());
	     	            System.out.println("Email: " + pessoa.getEmail());
	     	            System.out.println("Data de Nascimento: " + pessoa.getData());
	     	            System.out.println("---------------------------");
	     	        }
	     	    }
	     	    break;
	     	case "5": 
	     	    RacaDAO racaDAO = new RacaDAO();
	     	    List<Raca> racas = racaDAO.findAllrac();
	     	    
	     	    if (racas.isEmpty()) {
	     	        System.out.println("Nenhuma raça encontrada.");
	     	    } else {
	     	        System.out.println("Lista de Raças:");
	     	        for (Raca raca : racas) {
	     	            System.out.println("ID: " + raca.getId());
	     	            System.out.println("Nome: " + raca.getNome());
	     	            System.out.println("Descrição: " + raca.getDescricao());
	     	            System.out.println("ID do Tipo: " + raca.getTipo().getId());
	     	            System.out.println("---------------------------");
	     	        }
	     	    }
	     	    break;
	     	case "6": 
	     	    TipoDAO tipoDAO = new TipoDAO();
	     	    List<Tipo> tipos = tipoDAO.findAlltip();
	     	    
	     	    if (tipos.isEmpty()) {
	     	        System.out.println("Nenhum tipo encontrado.");
	     	    } else {
	     	        System.out.println("Lista de Tipos:");
	     	        for (Tipo tipo : tipos) {
	     	            System.out.println("ID: " + tipo.getId());
	     	            System.out.println("Nome: " + tipo.getNome());
	     	            System.out.println("---------------------------");
	     	        }
	     	    }
	     	    break;
	     	case "7": 
	     	    VeterinarioDAO vetDAO = new VeterinarioDAO();
	     	    List<Veterinario> veterinarios = vetDAO.findAllvet();
	     	    
	     	    if (veterinarios.isEmpty()) {
	     	        System.out.println("Nenhum veterinário encontrado.");
	     	    } else {
	     	        System.out.println("Lista de Veterinários:");
	     	        for (Veterinario veterinario : veterinarios) {
	     	            System.out.println("ID: " + veterinario.getId());
	     	            System.out.println("Nome: " + veterinario.getNome());
	     	            System.out.println("Certificação: " + veterinario.getCerti());
	     	            System.out.println("Local: " + veterinario.getLocal());
	     	            System.out.println("Especialização: " + veterinario.getEsp());
	     	            System.out.println("---------------------------");
	     	        }
	     	    }
	     	    break;

     	    
     	    }
         break;
    
         case "3":
        	    System.out.println("Menu:");
        	    System.out.println("(1) Atualizar Animal");
        	    System.out.println("(2) Atualizar Consulta");
        	    System.out.println("(3) Atualizar Doação");
        	    System.out.println("(4) Atualizar Pessoa");
        	    System.out.println("(5) Atualizar Raça");
        	    System.out.println("(6) Atualizar Tipo");
        	    System.out.println("(7) Atualizar Veterinário");
        	    System.out.print("Escolha uma opção: ");
        	    escolha = scanner.nextLine();
        	   

        	    switch (escolha) {
        	        case "1":
        	            AnimalDAO animalDAO = new AnimalDAO();
        	            Animal animal = new Animal();
        	            String esc;
        	            System.out.print("ID do Animal (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long id = Long.parseLong(esc);
        	            animal.setId(id); 

        	            System.out.print("Nome: ");
        	            esc = scanner.nextLine();
        	            animal.setNome(esc);
        	            System.out.print("Data de Nascimento: ");
        	            esc = scanner.nextLine();
        	            animal.setDatanasc(esc);
        	            System.out.print("Foto: ");
        	            esc = scanner.nextLine();
        	            animal.setFoto(esc);
        	            System.out.print("Foi doado? : ");
        	            esc = scanner.nextLine();
        	            boolean ddo = esc.equalsIgnoreCase("sim");
        	            animal.setDoado(ddo);
        	            System.out.print("Idade: ");
        	            esc = scanner.nextLine();
        	            int numero = Integer.parseInt(esc);
        	            animal.setIdade(numero);
        	            System.out.print("ID da raça: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Raca racani = new Raca();
        	            racani.setId(id);
        	            animal.setRaca(racani);
        	            System.out.print("ID do responsável: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Pessoa pesani = new Pessoa();
        	            pesani.setId(id);
        	            animal.setPessoa(pesani);
        	            animalDAO.updateani(animal);
        	            break;

        	        case "2":
        	            ConsultaDAO consultaDAO = new ConsultaDAO();
        	            Consulta consulta = new Consulta();
        	            System.out.print("ID da Consulta (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long consultaId = Long.parseLong(esc);
        	            consulta.setId(consultaId); 

        	            System.out.print("Diagnóstico: ");
        	            esc = scanner.nextLine();
        	            consulta.setDiagnostico(esc);
        	            System.out.print("Data: ");
        	            esc = scanner.nextLine();
        	            consulta.setData(esc);

        	            System.out.print("ID do animal: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Animal conani = new Animal();
        	            conani.setId(id);
        	            consulta.setAnimal(conani);
        	            System.out.print("ID do veterinário: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Veterinario convet = new Veterinario();
        	            convet.setId(id);
        	            consulta.setVet(convet);
        	            consultaDAO.updatecon(consulta);
        	            break;

        	        case "3":
        	            DoacaoDAO doacaoDAO = new DoacaoDAO();
        	            Doacao doacao = new Doacao();
        	            System.out.print("ID da Doação (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long doacaoId = Long.parseLong(esc);
        	            doacao.setId(doacaoId); 

        	            System.out.print("Estado: ");
        	            esc = scanner.nextLine();
        	            doacao.setEstado(esc);
        	            System.out.print("Descrição: ");
        	            esc = scanner.nextLine();
        	            doacao.setDescricao(esc);
        	            System.out.print("Data de Inicialização: ");
        	            esc = scanner.nextLine();
        	            doacao.setDatadoa(esc);
        	            System.out.print("Data de Finalização: ");
        	            esc = scanner.nextLine();
        	            doacao.setDatarec(esc);

        	            System.out.print("ID do animal: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Animal doani = new Animal();
        	            doani.setId(id);
        	            doacao.setAnimal(doani);
        	            System.out.print("ID do Donatário: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Pessoa dopes = new Pessoa();
        	            dopes.setId(id);
        	            doacao.setPessoa(dopes);
        	            doacaoDAO.updatedoa(doacao);
        	            break;

        	        case "4":
        	            PessoaDAO pessoaDAO = new PessoaDAO();
        	            Pessoa pessoa = new Pessoa();
        	            System.out.print("ID da Pessoa (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long pessoaId = Long.parseLong(esc);
        	            pessoa.setId(pessoaId); 

        	            System.out.print("Nome: ");
        	            esc = scanner.nextLine();
        	            pessoa.setNome(esc);
        	            System.out.print("Endereço: ");
        	            esc = scanner.nextLine();
        	            pessoa.setEndereco(esc);
        	            System.out.print("Telefone: ");
        	            esc = scanner.nextLine();
        	            pessoa.setTelefone(esc);
        	            System.out.print("Email: ");
        	            esc = scanner.nextLine();
        	            pessoa.setEmail(esc);
        	            System.out.print("Data de Nascimento: ");
        	            esc = scanner.nextLine();
        	            pessoa.setData(esc);
        	            pessoaDAO.updatepes(pessoa);
        	            break;

        	        case "5":
        	            RacaDAO racaDAO = new RacaDAO();
        	            Raca raca = new Raca();
        	            System.out.print("ID da Raça (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long racaId = Long.parseLong(esc);
        	            raca.setId(racaId); 

        	            System.out.print("Nome: ");
        	            esc = scanner.nextLine();
        	            raca.setNome(esc);
        	            System.out.print("Descrição: ");
        	            esc = scanner.nextLine();
        	            raca.setDescricao(esc);
        	            System.out.print("ID do tipo: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            Tipo rati = new Tipo();
        	            rati.setId(id);
        	            raca.setTipo(rati);
        	            racaDAO.updaterac(raca);
        	            break;

        	        case "6":
        	            TipoDAO tipoDAO = new TipoDAO();
        	            Tipo tipo = new Tipo();
        	            System.out.print("ID do Tipo (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long tipoId = Long.parseLong(esc);
        	            tipo.setId(tipoId); 

        	            System.out.print("Nome: ");
        	            esc = scanner.nextLine();
        	            tipo.setNome(esc);
        	            tipoDAO.updatetip(tipo);
        	            break;

        	        case "7":
        	            VeterinarioDAO vetDAO = new VeterinarioDAO();
        	            Veterinario veterinario = new Veterinario();
        	            System.out.print("ID do Veterinário (para atualizar): ");
        	            esc = scanner.nextLine();
        	            Long vetId = Long.parseLong(esc);
        	            veterinario.setId(vetId); 

        	            System.out.print("Nome: ");
        	            esc = scanner.nextLine();
        	            veterinario.setNome(esc);
        	            System.out.print("Certificação: ");
        	            esc = scanner.nextLine();
        	            veterinario.setCerti(esc);
        	            System.out.print("Local: ");
        	            esc = scanner.nextLine();
        	            veterinario.setLocal(esc);
        	            System.out.print("Especialização: ");
        	            esc = scanner.nextLine();
        	            veterinario.setEsp(esc);     
        	            vetDAO.updatevet(veterinario);
        	            break;

        	        default:
        	            System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        	    }
        	    break;
             
         case "4":
        	    System.out.println("Menu:");
        	    System.out.println("(1) Deletar Animal");
        	    System.out.println("(2) Deletar Consulta");
        	    System.out.println("(3) Deletar Doação");
        	    System.out.println("(4) Deletar Pessoa");
        	    System.out.println("(5) Deletar Raça");
        	    System.out.println("(6) Deletar Tipo");
        	    System.out.println("(7) Deletar Veterinário");
        	    System.out.print("Escolha uma opção: ");
        	    escolha = scanner.nextLine();
        	  

        	    switch (escolha) {
        	        case "1": 
        	            AnimalDAO animalDAO = new AnimalDAO();
        	            System.out.print("Insira o ID do Animal: ");
        	            String esc = scanner.nextLine();
        	            Long id = Long.parseLong(esc);
        	            animalDAO.deleteani(id);
        	            System.out.println("Animal excluído com sucesso!");
        	            break;

        	        case "2":
        	            ConsultaDAO consultaDAO = new ConsultaDAO();
        	            System.out.print("Insira o ID da Consulta: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            consultaDAO.deletecon(id);
        	            System.out.println("Consulta excluída com sucesso!");
        	            break;

        	        case "3":
        	            DoacaoDAO doacaoDAO = new DoacaoDAO();
        	            System.out.print("Insira o ID da Doação: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            doacaoDAO.deletedoa(id);
        	            System.out.println("Doação excluída com sucesso!");
        	            break;

        	        case "4":
        	            PessoaDAO pessoaDAO = new PessoaDAO();
        	            System.out.print("Insira o ID da Pessoa: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            pessoaDAO.deletepes(id);
        	            System.out.println("Pessoa excluída com sucesso!");
        	            break;

        	        case "5":
        	            RacaDAO racaDAO = new RacaDAO();
        	            System.out.print("Insira o ID da Raça: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            racaDAO.deleterac(id);
        	            System.out.println("Raça excluída com sucesso!");
        	            break;

        	        case "6":
        	            TipoDAO tipoDAO = new TipoDAO();
        	            System.out.print("Insira o ID do Tipo: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            tipoDAO.deletetip(id);
        	            System.out.println("Tipo excluído com sucesso!");
        	            break;

        	        case "7":
        	            VeterinarioDAO vetDAO = new VeterinarioDAO();
        	            System.out.print("Insira o ID do Veterinário: ");
        	            esc = scanner.nextLine();
        	            id = Long.parseLong(esc);
        	            vetDAO.deletevet(id);
        	            System.out.println("Veterinário excluído com sucesso!");
        	            break;

        	        default:
        	            System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
        	    }
        	    break;


        
         default:
             System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
             
  
     }
       


    }
}