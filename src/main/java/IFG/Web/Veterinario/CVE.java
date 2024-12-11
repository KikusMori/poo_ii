package IFG.Web.Veterinario;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.Class.Veterinario;
import IFG.DAOs.VeterinarioDAO;

//@WebServlet("/createVeterinario")
public class CVE extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String certificacao = request.getParameter("certificacao");
        String local = request.getParameter("local");
        String especialidade = request.getParameter("especialidade");

        Veterinario veterinario = new Veterinario();
        veterinario.setNome(nome);
        veterinario.setCerti(certificacao);
        veterinario.setLocal(local);
        veterinario.setEsp(especialidade);


 
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        try {
            veterinarioDAO.savevet(veterinario); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Veterinário criado com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + nome + "</p>");
            response.getWriter().write("<p>Certificação: " + certificacao + "</p>");
            response.getWriter().write("<p>Local: " + local + "</p>");
            response.getWriter().write("<p>Especialidade: " + especialidade + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar o veterinário");
        }
    }
}
