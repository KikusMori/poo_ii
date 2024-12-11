package IFG.Web.Doacao;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.DAOs.DoacaoDAO;



//@WebServlet("/deleteDoacao")
public class DD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        DoacaoDAO doacaoDAO = new DoacaoDAO();

        try {
            doacaoDAO.deletedoa(id);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro excluído com sucesso!</h1>");
            response.getWriter().write("<p>ID: " + id + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao deletar a doacao");
        }
        
    }
}
