package IFG.Web.Tipo;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.Class.Tipo;
import IFG.DAOs.TipoDAO;

//@WebServlet("/createTipo")
public class CT extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        Tipo tipo = new Tipo();
        tipo.setNome(nome);

        TipoDAO tipoDAO = new TipoDAO();
        try {
            tipoDAO.savetip(tipo); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Tipo criado com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + nome + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a Tipo");
        }
    }
}
