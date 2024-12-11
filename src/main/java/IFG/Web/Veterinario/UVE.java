package IFG.Web.Veterinario;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.Class.Veterinario;
import IFG.DAOs.VeterinarioDAO;

//@WebServlet("/updateVeterinario")
public class UVE extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String certificacao = request.getParameter("certificacao");
        String local = request.getParameter("local");
        String especialidade = request.getParameter("especialidade");

        Veterinario veterinario = new Veterinario(id, nome, certificacao, local, especialidade);
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        
        try {
            veterinarioDAO.updatevet(veterinario);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro atualizado com sucesso!</h1>");
            response.getWriter().println("<p>Nome: " + veterinario.getNome() + "</p>");
            response.getWriter().write("<p>Certificação: " + veterinario.getCerti() + "</p>");
            response.getWriter().write("<p>Local: " + veterinario.getLocal() + "</p>");
            response.getWriter().write("<p>Especialidade: " + veterinario.getEsp() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar o veterinário");
        }
    }
}
