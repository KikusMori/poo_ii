package IFG.Web.Raca;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import IFG.Class.Raca;
import IFG.DAOs.RacaDAO;

//@WebServlet("/selectRaca")
public class RR extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        RacaDAO racaDAO = new RacaDAO();

        Optional<Raca> racaOptional = racaDAO.findByIdrac(id);
        Raca raca = racaOptional.get(); 
        try {
            if (raca == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Raca não encontrada");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Raca Selecionada</h1>");
            response.getWriter().println("<p>Nome: " + raca.getNome() + "</p>");
            response.getWriter().println("<p>Descrição: " + raca.getDescricao() + "</p>");
            response.getWriter().println("<p>Tipo: " + raca.tipoString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar a raca");
        }
    }
}
