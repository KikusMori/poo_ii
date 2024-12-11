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

//@WebServlet("/selectAnimal")
public class RA extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        AnimalDAO animalDAO = new AnimalDAO();

        Optional<Animal> animalOptional = animalDAO.findByIdani(id);
        Animal animal = animalOptional.get(); 
        try {

            if (animal == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Animal não encontrado");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Animal selecionado com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + animal.getNome() + "</p>");
            response.getWriter().write("<p>Data de Nascimento: " + animal.getDatanasc() + "</p>");
            response.getWriter().write("<p>Foto: " + animal.getFoto() + "</p>");
            response.getWriter().write("<p>Doado: " + animal.getDoado() + "</p>");
            response.getWriter().write("<p>Idade: " + animal.getIdade() + "</p>");
            response.getWriter().write("<p>Dono: " + animal.donoString() + "</p>");
            response.getWriter().write("<p>Raça: " + animal.racaString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar o animal");
        }
    }
}
