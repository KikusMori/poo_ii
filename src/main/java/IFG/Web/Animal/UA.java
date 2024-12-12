package IFG.Web.Animal;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.Class.Animal;
import IFG.DAOs.AnimalDAO;
import IFG.DAOs.PessoaDAO;
import IFG.DAOs.RacaDAO;
import IFG.Class.Pessoa;
import IFG.Class.Raca;

//@WebServlet("/updateAnimal")
public class UA extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String datanasc = request.getParameter("datanasc");
        String foto = request.getParameter("foto");
        String strD = request.getParameter("doado");
        boolean doado = Boolean.parseBoolean(strD);
        String strI = request.getParameter("idade");
        int idade = Integer.parseInt(strI);
        String idp = request.getParameter("idp");
        String idr = request.getParameter("idr");

        Pessoa pessoa = null;
        Long pid = Long.parseLong(idp); 
        PessoaDAO pessoaDAO = new PessoaDAO();
        Optional<Pessoa> pessoaOptional = pessoaDAO.findByIdpes(pid);
        pessoa = pessoaOptional.get(); 

        Raca raca = null;
        Long rid = Long.parseLong(idr); 
        RacaDAO racaDAO = new RacaDAO();
        Optional<Raca> racaOptional = racaDAO.findByIdrac(rid);
        raca = racaOptional.get(); 


        Animal animal = new Animal(id, nome, datanasc, foto, doado, idade, pessoa, raca);
        AnimalDAO animalDAO = new AnimalDAO();
        
        try {
            animalDAO.updateani(animal);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro atualizado com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + animal.getNome() + "</p>");
            response.getWriter().write("<p>Data de Nascimento: " + animal.getDatanasc() + "</p>");
            response.getWriter().write("<p>Foto: " + animal.getFoto() + "</p>");
            response.getWriter().write("<p>Doado: " + animal.getDoado() + "</p>");
            response.getWriter().write("<p>Idade: " + animal.getIdade() + "</p>");
            response.getWriter().write("<p>Dono: " + pessoa.getNome() + "</p>");
            response.getWriter().write("<p>Raça: " + raca.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar o animal");
        }
    }
}
