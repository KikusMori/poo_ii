package IFG.Web.Tipo;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import IFG.Class.Tipo;
import IFG.DAOs.TipoDAO;

//@WebServlet("/selectTipo")
public class RT extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        TipoDAO tipoDAO = new TipoDAO();

        Optional<Tipo> tipoOptional = tipoDAO.findByIdtip(id);
        Tipo tipo = tipoOptional.get(); 

        try {
            if (tipo == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Tipo não encontrado");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Pessoa Selecionada</h1>");
            response.getWriter().println("<p>Nome: " + tipo.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar o tipo");
        }
    }
}
