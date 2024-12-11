package IFG.Web.Veterinario;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import IFG.Class.Veterinario;
import IFG.DAOs.VeterinarioDAO;

//@WebServlet("/selectVeterinario")
public class RVE extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();

        Optional<Veterinario> veterinarioOptional = veterinarioDAO.findByIdvet(id);
        Veterinario veterinario = veterinarioOptional.get(); 
        
        try {

            if (veterinario == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Veterinário não encontrado.");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Veterinário Selecionado</h1>");
            response.getWriter().println("<p>Nome: " + veterinario.getNome() + "</p>");
            response.getWriter().write("<p>Certificação: " + veterinario.getCerti() + "</p>");
            response.getWriter().write("<p>Local: " + veterinario.getLocal() + "</p>");
            response.getWriter().write("<p>Especialidade: " + veterinario.getEsp() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar o veterinário");
        }
    }
}
